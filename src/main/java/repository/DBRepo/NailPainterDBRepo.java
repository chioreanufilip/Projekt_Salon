package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.NailPainter;
import com.microsoft.sqlserver.jdbc.SQLServerException;
public class NailPainterDBRepo extends DBRepository<NailPainter> {
    public NailPainterDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(NailPainter obj) {
        String SQL="insert into NailPainter(ID,name,experience,speciality,gelNailExperience) values (?,?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setInt(3, obj.getExperience());
            statement.setString(4, obj.getSpeciality());
            statement.setString(5,obj.getGelNailExperience());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    @Override
    public void update(NailPainter obj) {
        String SQL = "update NailPainter set name=?,experience=?,speciality=?,gelNailExperience=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setInt(2,obj.getExperience());
            statement.setString(3,obj.getSpeciality());
            statement.setString(4,obj.getGelNailExperience());
            statement.setInt(5,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer id) {
        String SQL2="delete from Service_Employees where ID_NailPainter=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from NailPainter where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public List<NailPainter> getAll() {
        String SQL = "select * from NailPainter;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<NailPainter> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new NailPainter(rs.getString("name"),rs.getInt("experience"),rs.getString("Speciality"),rs.getString("gelNailExperience"),rs.getInt("ID")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NailPainter getById(Integer id) {
        try{
        String SQL = "select * from NailPainter where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new NailPainter(rs.getString("name"),rs.getInt("experience"),rs.getString("Speciality"),rs.getString("gelNailExperience"),rs.getInt("ID"));
            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
