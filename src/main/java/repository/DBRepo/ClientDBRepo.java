package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Client;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ClientDBRepo extends DBRepository<Client> {
    public ClientDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Client obj) {
        String SQL="insert into Client(ID,Name,PhoneNumber) values (?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setString(3, obj.getPhoneNumber());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    @Override
    public void update(Client obj) {
        String SQL = "update Client set Name=?,PhoneNumber=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setString(2,obj.getPhoneNumber());
            statement.setInt(3,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer id) {
//        String SQl = "delete from Payments where ClientID =?";
//        try(PreparedStatement statement = connection.prepareStatement(SQl)){
//            statement.setInt(1,id);
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
//        String SQl1 = "delete p from Payments_Services p join Payments p1 on p.ID_Payment =p1.ID where p1.ClientID =?";
//        try(PreparedStatement statement = connection.prepareStatement(SQl1)){
//            statement.setInt(1,id);
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
        String SQL5 = "delete from Appointment where ClientID=?";
        try(PreparedStatement statement= (connection.prepareStatement(SQL5))) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL1 = "delete from Payments where ClientID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL1)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL2="delete from Review where ClientID=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Client where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

    }

    @Override
    public List<Client> getAll() {
        String SQL = "select * from Client;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Client> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Client(rs.getInt("ID"),rs.getString("Name"),rs.getString("PhoneNumber")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client getById(Integer id) {
        try{
        String SQL = "select * from Client where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("ID"),rs.getString("Name"),rs.getString("PhoneNumber"));

            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
