package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Produce;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ProductDBRepo extends DBRepository<Produce>{
    public ProductDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Produce obj) {
        String SQL="insert into Product(ID,Name,Price,Stock,Type) values (?,?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setDouble(3, obj.getPrice());
            statement.setInt(4, obj.getStock());
            statement.setInt(5,obj.getType());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    @Override
    public void update(Produce obj) {
        String SQL = "update Product set Name=?,Price=?,Stock=?,Type=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setDouble(2,obj.getPrice());
            statement.setInt(3,obj.getStock());
            statement.setInt(4,obj.getType());
            statement.setInt(5,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer id) {
        String SQL3 = "delete from Payments where ID_Products=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL3)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Product where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public List<Produce> getAll() {
        String SQL = "select * from Product;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Produce> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Produce(rs.getString("Name"),rs.getDouble("Price"),rs.getInt("Stock"),rs.getInt("Type"),rs.getInt("ID")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Produce getById(Integer id) {
        try{
        String SQL = "select * from Product where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Produce(rs.getString("Name"),rs.getDouble("Price"),rs.getInt("Stock"),rs.getInt("Type"),rs.getInt("ID"));
            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
