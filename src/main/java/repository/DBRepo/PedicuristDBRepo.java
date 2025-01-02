package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Pedicurist;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class PedicuristDBRepo extends DBRepository<Pedicurist>{
    public PedicuristDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Pedicurist obj) {
        String SQL="insert into Pedicurist(ID,name,experience,speciality,FootCareSpecialisation) values (?,?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setInt(3, obj.getExperience());
            statement.setString(4, obj.getSpeciality());
            statement.setString(5,obj.getFootCareSpecialisation());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    @Override
    public void update(Pedicurist obj) {
        String SQL = "update Pedicurist set name=?,experience=?,speciality=?,FootCareSpecialisation=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setInt(2,obj.getExperience());
            statement.setString(3,obj.getSpeciality());
            statement.setString(4,obj.getFootCareSpecialisation());
            statement.setInt(5,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer id) {
        String SQL2="delete from Service_Employees where ID_Pedicurist=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Pedicurist where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public List<Pedicurist> getAll() {
        String SQL = "select * from Pedicurist;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Pedicurist> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Pedicurist(rs.getString("name"),rs.getInt("experience"),rs.getString("Speciality"),rs.getString("FootCareSpecialisation"),rs.getInt("ID")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pedicurist getById(Integer id) {
        try{
        String SQL = "select * from Pedicurist where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Pedicurist(rs.getString("name"),rs.getInt("experience"),rs.getString("Speciality"),rs.getString("FootCareSpecialisation"),rs.getInt("ID"));
            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
