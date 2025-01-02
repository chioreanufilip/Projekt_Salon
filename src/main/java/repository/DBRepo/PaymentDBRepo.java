package repository.DBRepo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.EntityNotFoundException;
import Module.Payment;
import Module.Service;
import Module.Produce;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class PaymentDBRepo extends DBRepository<Payment> {
    public PaymentDBRepo(String URL) {
        super(URL);
    }
    @Override
    public void create(Payment obj) {
        insertSQL(obj);
    }

    private void insertSQL(Payment obj){
        String SQL="insert into Payments(ID_Payment,ClientID,ID_Products,ID_Services,Amount) values (?,?,?,?,?);";
        Integer i=0;
//        Integer j=0;
        while (i<obj.getServices().size() || i<obj.getProducts().size()) {
            if (i<obj.getServices().size() && i<obj.getProducts().size()) {
                try (PreparedStatement statement = connection.prepareStatement(SQL)){
                    statement.setInt(1,obj.getId());
                    statement.setInt(2,obj.getClientId());
                    statement.setInt(3,obj.getProducts().get(i).getId());
                    statement.setInt(4,obj.getServices().get(i).getId());
                    statement.setDouble(5,obj.getAmount());
                    i++;
                    statement.executeUpdate();

                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
            else if(i<obj.getServices().size()) {
                try (PreparedStatement statement = connection.prepareStatement(SQL)){
                    statement.setInt(1,obj.getId());
                    statement.setInt(2,obj.getClientId());
                    statement.setNull(3,java.sql.Types.INTEGER);
                    statement.setInt(4,obj.getServices().get(i).getId());
                    statement.setDouble(5,obj.getAmount());
                    i++;
                    statement.executeUpdate();
                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
            else if (i<obj.getProducts().size()) {
                try (PreparedStatement statement = connection.prepareStatement(SQL)){
                    statement.setInt(1,obj.getId());
                    statement.setInt(2,obj.getClientId());
                    statement.setInt(3,obj.getProducts().get(i).getId());
                    i++;
                    statement.setNull(4, java.sql.Types.INTEGER);
                    statement.setDouble(5,obj.getAmount());
                    statement.executeUpdate();
                }
                catch (SQLServerException e){}
                catch (SQLException e) {throw new RuntimeException(e);}
            }
        }
//        String SQL1 = "insert into Payments_Services(ID_Payment,ID_Services) values (?,?);";
//        for (Service employee : obj.getServices()){
////            if (employee instanceof Barber){
//                try(PreparedStatement statement=connection.prepareStatement(SQL1)){
//                    statement.setInt(1, obj.getId());
//                    statement.setInt(2, employee.getId());
////                    statement.setNull(3, java.sql.Types.INTEGER);
////                    statement.setNull(4, java.sql.Types.INTEGER);
//                    statement.executeUpdate();
//                }
//                catch (SQLServerException e){}
//                catch (SQLException e) {throw new RuntimeException(e);}
////            }
//        }
//        String SQL2 = "insert into Payments_Products(ID_Payment,ID_Products) values (?,?);";
//        for (Produce produce :obj.getProducts()){
//            try(PreparedStatement statement = connection.prepareStatement(SQL2)){
//                statement.setInt(1, obj.getId());
//                statement.setInt(2, produce.getId());
//                statement.executeUpdate();
//            }
//            catch (SQLServerException e ){}
//            catch (SQLException e) {throw new RuntimeException(e);}
//        }
    }
    @Override
    public void update(Payment obj) {
        String SQL = "delete from Payments  where ID_Payment=?";
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
//        String SQL1 = "delete from Payments_Services where ID_Payment=?";
//        try (PreparedStatement statement=connection.prepareStatement(SQL1)) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
//        String SQL3 = "delete from Payments_Products where ID_Payment=?";
//        try (PreparedStatement statement=connection.prepareStatement(SQL3)) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//        catch (SQLException e){throw new RuntimeException(e);}
        String SQL = "delete from Appointment where PaymentID=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        String SQL2="delete from Payments where ID_Payment=?";
        try (PreparedStatement statement =connection.prepareStatement(SQL2)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e){throw new RuntimeException(e);}

    }
    private List<Service> getServicPay(Integer ID_Service){
//        List<Employee> employees = new ArrayList<Employee>();
        String SQL1 = "select * from Payments where ID_Payment=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL1)){
            statement.setInt(1, ID_Service);
            ResultSet rs = statement.executeQuery();
            List<Service> list = new ArrayList<>();
            while (rs.next()){
//                int idBarber = rs.getInt("ID_Barber");
//                int idPedicurist = rs.getInt("ID_Pedicurist");
//                int idNailPainter = rs.getInt("ID_NailPainter");
                int idService = rs.getInt("ID_Services");
                if(!rs.wasNull()){
                      String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                      ServiceDBRepo serv = new ServiceDBRepo(DBUrl1);
                      list.add(serv.getById(idService));
//                    if(idBarber!=0){
//                        String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        BarberDBRepo barb = new BarberDBRepo(DBUrl1);
//                        list.add(barb.getById(idBarber));
//                    }
//                    if(idPedicurist!=0){
//                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        PedicuristDBRepo ped = new PedicuristDBRepo(DBUrl);
//                        list.add(ped.getById(idPedicurist));
//                    }
//                    if(idNailPainter!=0){
//                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        NailPainterDBRepo nail = new NailPainterDBRepo(DBUrl);
//                        list.add(nail.getById(idNailPainter));
//                    }
                }
            }
            return list;
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }
    private List<Produce> getProductPay(Integer ID_Produce){
//        List<Employee> employees = new ArrayList<Employee>();
        String SQL1 = "select * from Payments where ID_Payment=?;";
        try (PreparedStatement statement = connection.prepareStatement(SQL1)){
            statement.setInt(1, ID_Produce);
            ResultSet rs = statement.executeQuery();
            List<Produce> list = new ArrayList<>();
            while (rs.next()){
//                int idBarber = rs.getInt("ID_Barber");
//                int idPedicurist = rs.getInt("ID_Pedicurist");
//                int idNailPainter = rs.getInt("ID_NailPainter");
                int idService = rs.getInt("ID_Products");
                if(!rs.wasNull()){
                      String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
                      ProductDBRepo prod = new ProductDBRepo(DBUrl1);
                      list.add(prod.getById(idService));
//                    if(idBarber!=0){
//                        String DBUrl1 ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        BarberDBRepo barb = new BarberDBRepo(DBUrl1);
//                        list.add(barb.getById(idBarber));
//                    }
//                    if(idPedicurist!=0){
//                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        PedicuristDBRepo ped = new PedicuristDBRepo(DBUrl);
//                        list.add(ped.getById(idPedicurist));
//                    }
//                    if(idNailPainter!=0){
//                        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//                        NailPainterDBRepo nail = new NailPainterDBRepo(DBUrl);
//                        list.add(nail.getById(idNailPainter));
//                    }
                }
            }
            return list;
        }
        catch (SQLException e){throw new RuntimeException(e);}
    }
    @Override
    public List<Payment> getAll() {
        String SQL = "select ID_Payment,ClientID from Payments group by ID_Payment, ClientID;";
//        String SQL1 = "select * from Service_Employees;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet rs = statement.executeQuery();
            List<Payment> list = new ArrayList<>();
            while (rs.next()) {
                List<Service> services = getServicPay(rs.getInt("ID_Payment"));
                List<Produce> products = getProductPay(rs.getInt("ID_Payment"));
                list.add(new Payment(rs.getInt("ID_Payment"),services,products,rs.getInt("ClientID")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment getById(Integer id) {
        try{
        String SQL = "select ID_Payment,ClientID,Amount from Payments where ID_Payment=? group by ID_Payment, ClientID,Amount ;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                List<Service> services = getServicPay(rs.getInt("ID_Payment"));
                List<Produce> products = getProductPay(rs.getInt("ID_Payment"));
                Integer amount = rs.getInt("Amount");
                return new Payment(rs.getInt("ID_Payment"),services,products,rs.getInt("ClientID"),amount);

            }
            else throw new EntityNotFoundException();
        }
        catch (SQLException e){throw new RuntimeException(e);}}
        catch (EntityNotFoundException e){throw new EntityNotFoundException();}
    }
}
