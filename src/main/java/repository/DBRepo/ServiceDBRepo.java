package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Exceptions.ValidationException;
import Module.Service;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import Module.Barber;
import Module.Pedicurist;
import Module.NailPainter;
import Module.Employee;
public class ServiceDBRepo extends DBRepository<Service>{
    public ServiceDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Service obj) {
        String SQL="insert into Service(ID,Name,Duration,Price) values (?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){//System.out.println("Hello");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setString(3, obj.getDuration());
            statement.setDouble(4, obj.getPrice());
            statement.executeUpdate();
        }
        catch (SQLServerException e){}
        catch (SQLException e) {throw new RuntimeException(e);}
//        String SQL1 = "insert into Service_Employees(ID_Service,ID_Barber,ID_Pedicurist,ID_NailPainter) values (?,?,?,?);";
//        for (Employee employee : obj.getEmployees()){
//            if (employee instanceof Barber){
//        try(PreparedStatement statement=connection.prepareStatement(SQL1)){
//            statement.setInt(1, obj.getId());
//            statement.setInt(2, employee.getId());
//            statement.setNull(3, java.sql.Types.INTEGER);
//            statement.setNull(4, java.sql.Types.INTEGER);
//            statement.executeUpdate();
//        }
//        catch (SQLServerException e){}
//        catch (SQLException e) {throw new RuntimeException(e);}
//    }
//            else if (employee instanceof Pedicurist){
//                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
//                    statement.setInt(1, obj.getId());
//                    statement.setNull(2, java.sql.Types.INTEGER);
//                    statement.setInt(3, employee.getId());
//                    statement.setNull(4, java.sql.Types.INTEGER);
//                    statement.executeUpdate();
//                }
//                catch (SQLServerException e){}
//                catch (SQLException e) {throw new RuntimeException(e);}
//            }
//            else if (employee instanceof NailPainter){
//                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
//                    statement.setInt(1, obj.getId());
//                    statement.setNull(2, java.sql.Types.INTEGER);
//                    statement.setNull(3, java.sql.Types.INTEGER);
//                    statement.setInt(4, employee.getId());
//                    statement.executeUpdate();
//                }
//                catch (SQLServerException e){}
//                catch (SQLException e) {throw new RuntimeException(e);}
//            }
//            }
        insertSQL(obj);
            }

    private void insertSQL(Service obj){
        String SQL1 = "insert into Service_Employees(ID_Service,ID_Barber,ID_Pedicurist,ID_NailPainter) values (?,?,?,?);";
        for (Employee employee : obj.getEmployees()){
            if (employee instanceof Barber){
                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
                    statement.setInt(1, obj.getId());
                    statement.setInt(2, employee.getId());
                    statement.setNull(3, java.sql.Types.INTEGER);
                    statement.setNull(4, java.sql.Types.INTEGER);
                    statement.executeUpdate();
                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
            else if (employee instanceof Pedicurist){
                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
                    statement.setInt(1, obj.getId());
                    statement.setNull(2, java.sql.Types.INTEGER);
                    statement.setInt(3, employee.getId());
                    statement.setNull(4, java.sql.Types.INTEGER);
                    statement.executeUpdate();
                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
            else if (employee instanceof NailPainter){
                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
                    statement.setInt(1, obj.getId());
                    statement.setNull(2, java.sql.Types.INTEGER);
                    statement.setNull(3, java.sql.Types.INTEGER);
                    statement.setInt(4, employee.getId());
                    statement.executeUpdate();
                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
        }
    }
    @Override
    public void update(Service obj) {
        String SQL = "update Service set Name=?,Duration=?,Price=? where ID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1,obj.getName());
            statement.setString(2,obj.getDuration());
            statement.setDouble(3,obj.getPrice());
            statement.setInt(4,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

        String SQL1 = "delete from Service_Employees where ID_Service=?";
            try (PreparedStatement statement=connection.prepareStatement(SQL1)) {
                statement.setInt(1, obj.getId());
                statement.executeUpdate();
            }
            catch (SQLException e){throw new RuntimeException(e);}
//        String SQL1 = "insert into Service_Employees(ID_Service,ID_Barber,ID_Pedicurist,ID_NailPainter) values (?,?,?,?);";
        insertSQL(obj);
    }

    @Override
    public void delete(Integer id) {
        String SQL5 = "delete from Appointment where ServiceID=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL5)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL1 = "delete from Payments where ID_Services=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL1)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL2="delete from Service_Employees where ID_Service=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Service where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

    }
    private List<Employee> getServiceEmployee(Integer ID_Service){
//        List<Employee> employees = new ArrayList<Employee>();
        String SQL1 = "select * from Service_Employees where ID_Service=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL1)){
            statement.setInt(1, ID_Service);
            ResultSet rs = statement.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (rs.next()){
                int idBarber = rs.getInt("ID_Barber");
                int idPedicurist = rs.getInt("ID_Pedicurist");
                int idNailPainter = rs.getInt("ID_NailPainter");
//                if(!rs.wasNull()){
                    if(idBarber!=0){
                        String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                        BarberDBRepo barb = new BarberDBRepo(DBUrl1);
                        list.add(barb.getById(idBarber));
                    }
                    if(idPedicurist!=0){
                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                        PedicuristDBRepo ped = new PedicuristDBRepo(DBUrl);
                        list.add(ped.getById(idPedicurist));
                    }
                    if(idNailPainter!=0){
                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                        NailPainterDBRepo nail = new NailPainterDBRepo(DBUrl);
                        list.add(nail.getById(idNailPainter));
                    }
//                }
            }
            return list;
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }
    @Override
    public List<Service> getAll() {
        String SQL = "select * from Service;";
//        String SQL1 = "select * from Service_Employees;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Service> list = new ArrayList<>();
            while (rs.next()) {
                List<Employee> employees = getServiceEmployee(rs.getInt("ID"));
                list.add(new Service(rs.getInt("ID"),rs.getString("Name"),rs.getString("Duration"),rs.getDouble("Price"),employees));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Service getById(Integer id) {
        try{
        String SQL = "select * from Service where ID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                List<Employee> list = getServiceEmployee(rs.getInt("ID"));
//                list<Employee>
                return new Service(rs.getInt("ID"),rs.getString("Name"),rs.getString("Duration"),rs.getDouble("Price"),list);

            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }

}
