package PharmacyManagement;

	
import java.sql.*;
import java.util.ArrayList;

public class DbConnect {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    public DbConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypharamadb", "root", "");
            statement = connection.createStatement();
        } catch (Exception e){
            System.out.println("Failed to established connection.");
        }
    }
    public void addOrders(String name, String price){

        try {
//            PreparedStatement st = connection.prepareStatement("INSERT INTO orders (name,price) VALUES (?,?)");
//            for (String order : orders) {
//                String name = order.split(",")[0];
//                int price = Integer.parseInt(order.split(",")[1]);
//            }
            statement.executeUpdate("INSERT INTO orders (name,price) VALUES ('"+name+"','"+price+"')");
        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public ResultSet getOrderList(){
//        ArrayList<String[]> list = new ArrayList<String[]>();
        try{
            resultSet = statement.executeQuery("SELECT * FROM orders");

            return resultSet;
        }catch(SQLException e){
            return null;
        }
    }
    public ResultSet getProductList(){
//        ArrayList<String[]> list = new ArrayList<String[]>();
        try{
            resultSet = statement.executeQuery("SELECT * FROM Products");

            return resultSet;
        }catch(SQLException e){
            return null;
        }
    }
}



