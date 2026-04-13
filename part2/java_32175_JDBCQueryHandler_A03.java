import java.sql.*;
import java.util.Base64;

public class java_32175_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;

    // Constructor to create a connection
    public java_32175_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Using MySQL JDBC driver
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to execute a query with parameter
    public ResultSet executeQuery(String query, String parameter) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, parameter);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to execute a non-query
    public int executeNonQuery(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Method to close connection and statement
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the connection
    public Connection getConnection() {
        return connection;
    }
}