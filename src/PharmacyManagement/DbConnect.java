package PharmacyManagement;

import java.sql.*;

public class DbConnect {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            statement = connection.createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS MyPharmaDB");
            statement.execute("USE MyPharmaDB");
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS MyPharmaDB.orders(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50) NOT NULL, price INT NOT NULL, PRIMARY KEY (id))");
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS MyPharmaDB.products(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50) NOT NULL, quantity INT NOT NULL, PRIMARY KEY (id))");
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS MyPharmaDB.users(name VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL, PRIMARY KEY (email))");
        } catch (Exception e) {
            System.out.println("Failed to established connection.");
        }
    }

    public void addOrders(String name, String price) {

        try {
            // PreparedStatement st = connection.prepareStatement("INSERT INTO orders
            // (name,price) VALUES (?,?)");
            // for (String order : orders) {
            // String name = order.split(",")[0];
            // int price = Integer.parseInt(order.split(",")[1]);
            // }
            statement.executeUpdate("INSERT INTO orders (name,price) VALUES ('" + name + "','" + price + "')");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ResultSet getOrderList() {
        // ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM orders");

            return resultSet;
        } catch (SQLException e) {
            return null;
        }
    }

    public ResultSet getProductList() {
        // ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM Products");

            return resultSet;
        } catch (SQLException e) {
            return null;
        }
    }
}
