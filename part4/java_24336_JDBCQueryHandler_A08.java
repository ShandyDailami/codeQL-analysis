import java.sql.*;

public class java_24336_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_24336_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM Users WHERE username = 'admin' AND password = 'password'");

        try {
            if (resultSet != null && resultSet.next()) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("User authentication failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}