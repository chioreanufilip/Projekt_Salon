package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.DatabaseException;
import Exceptions.EntityNotFoundException;
import Module.Barber;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class BarberDBRepo extends DBRepository<Barber> {
    public BarberDBRepo(String DBUrl) {
        super(DBUrl);
    }
@Override
public void create(Barber obj) {
    String SQL="insert into Barber(ID,name,hairStyle,Experience,Specialisation) values (?,?,?,?,?);";
    try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
statement.setInt(1, obj.getId());
statement.setString(2, obj.getName());
statement.setString(3, obj.getHairStyle());
statement.setInt(4, obj.getExperience());
statement.setString(5,obj.getSpeciality());
statement.executeUpdate();
    }
    catch (SQLServerException e){}
    catch (SQLException e) {throw new DatabaseException();}
}
@Override
    public void update(Barber obj) {
        String SQL = "update Barber set name=?,hairStyle=?,Experience=?,Specialisation=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setString(2,obj.getHairStyle());
            statement.setInt(3,obj.getExperience());
            statement.setString(4,obj.getSpeciality());
            statement.setInt(5,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new DatabaseException();}
}

    @Override
    public void delete(Integer id) {
        String SQL2="delete from Service_Employees where ID_Barber=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Barber where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        catch (SQLException e){throw new DatabaseException();}
    }

    @Override
    public List<Barber> getAll() {
        String SQL = "select * from Barber;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Barber> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Barber(rs.getString("name"),rs.getString("hairStyle"),
                        rs.getInt("Experience"),rs.getString("Specialisation"),rs.getInt("ID")));
            }
            return list;
        } catch (SQLException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public Barber getById(Integer id) {
        try{
        String SQL = "select * from Barber where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Barber(rs.getString("name"),rs.getString("hairStyle"),
                        rs.getInt("Experience"),rs.getString("Specialisation"),rs.getInt("ID"));
            }
            else throw new EntityNotFoundException();
//            return null;
        }
//        return null;
        catch (SQLException e){throw new DatabaseException();}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }

    }

