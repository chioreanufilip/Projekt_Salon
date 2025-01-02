package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Review;
import com.microsoft.sqlserver.jdbc.SQLServerException;
public class ReviewDBRepo extends DBRepository<Review> {
    public ReviewDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Review obj) {
        String SQL="insert into Review(ID,Rating,comment,ClientID) values (?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setInt(2, obj.getRating());
            statement.setString(3, obj.getComment());
            statement.setInt(4, obj.getClientId());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    @Override
    public void update(Review obj) {
        String SQL = "update Review set Rating=?,comment=?,ClientID=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setInt(1,obj.getRating());
            statement.setString(2,obj.getComment());
            statement.setInt(3,obj.getClientId());
            statement.setInt(4, obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from Review where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public List<Review> getAll() {
        String SQL = "select * from Review;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Review> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Review(rs.getInt("ID"),rs.getInt("Rating"),rs.getString("comment"),rs.getInt("ClientID")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Review getById(Integer id) {
        try{
        String SQL = "select * from Review where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Review(rs.getInt("ID"),rs.getInt("Rating"),rs.getString("comment"),rs.getInt("ClientID"));
            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
