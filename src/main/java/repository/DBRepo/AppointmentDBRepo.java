package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Service;
import Module.Appointment;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class AppointmentDBRepo extends DBRepository<Appointment> {
    public AppointmentDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Appointment obj) {
        insertSQL(obj);
    }

    private void insertSQL(Appointment obj){
        String SQL="insert into Appointment(ID_Appointment,dateTime,ClientId,ServiceID,PaymentID) values (?,?,?,?,?);";
        Integer i=0;
//        Integer j=0;
        while (i<obj.getService().size()) {
            try (PreparedStatement statement = connection.prepareStatement(SQL)){
                    statement.setInt(1,obj.getId());
                    statement.setString(2,obj.getDateTime());
                    statement.setInt(3,obj.getClient().getId());
                    statement.setInt(4,obj.getService().get(i).getId());
                    statement.setInt(5,obj.getPayment().getId());
//                    System.out.println(obj.getPayment().getId());
                    i++;
                    statement.executeUpdate();

                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
        }
    }
    @Override
    public void update(Appointment obj) {
        String SQL = "delete from Appointment where ID_Appointment=?";
        try (PreparedStatement statement=connection.prepareStatement(SQL)){
//            statement.setInt(1,obj.getClientId());
//            statement.setString(2,obj.getDuration());
//            statement.setDouble(3,obj.getPrice());
            statement.setInt(1,obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

//        String SQL1 = "delete from Payments_Services where ID_Payment=?";
//        try (PreparedStatement statement=connection.prepareStatement(SQL1)) {
//            statement.setInt(1, obj.getId());
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
//        String SQL3 = "delete from Payments_Products where ID_Payment=?";
//        try (PreparedStatement statement=connection.prepareStatement(SQL3)) {
//            statement.setInt(1, obj.getId());
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
//        String SQL1 = "insert into Service_Employees(ID_Service,ID_Barber,ID_Pedicurist,ID_NailPainter) values (?,?,?,?);";
        insertSQL(obj);
    }

    @Override
    public void delete(Integer id) {
        String SQL2="delete from Appointment where ID_Appointment=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

    }
    private List<Service> getServicPay(Integer ID_Service){
//        List<Employee> employees = new ArrayList<Employee>();
        String SQL1 = "select * from Appointment where ID_Appointment=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL1)){
            statement.setInt(1, ID_Service);
            ResultSet rs = statement.executeQuery();
            List<Service> list = new ArrayList<>();
            while (rs.next()){
                int idService = rs.getInt("ServiceID");
                if(!rs.wasNull()){
                    String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                    ServiceDBRepo serv = new ServiceDBRepo(DBUrl1);
                    list.add(serv.getById(idService));
                }
            }
            return list;
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }

    @Override
    public List<Appointment> getAll() {
        String SQL = "select ID_Appointment,dateTime,ClientID,PaymentID from Appointment group by ID_Appointment,dateTime,ClientID,PaymentID;";
//        String SQL1 = "select * from Service_Employees;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Appointment> list = new ArrayList<>();
            while (rs.next()) {
                List<Service> services = getServicPay(rs.getInt("ID_Appointment"));
//                int idService = rs.getInt("ID_Services");
                String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                ClientDBRepo serv = new ClientDBRepo(DBUrl1);
                PaymentDBRepo pat = new PaymentDBRepo(DBUrl1);
                list.add(new Appointment(rs.getInt("ID_Appointment"),rs.getString("dateTime"),serv.getById(rs.getInt("ClientId")),services,pat.getById(rs.getInt("PaymentID"))));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Appointment getById(Integer id) {
        try{
        String SQL = "select ID_Appointment,dateTime,ClientID,PaymentID from Appointment where ID_Appointment=? group by ID_Appointment,dateTime,ClientID,PaymentID ;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                List<Service> services = getServicPay(rs.getInt("ID_Appointment"));
                String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                ClientDBRepo serv = new ClientDBRepo(DBUrl1);
                PaymentDBRepo pat = new PaymentDBRepo(DBUrl1);
                return new Appointment(rs.getInt("ID_Appointment"),rs.getString("dateTime"),serv.getById(rs.getInt("ClientId")),services,pat.getById(rs.getInt("PaymentID")));

            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}

