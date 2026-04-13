import java.sql.*;

public class java_03500_JDBCQueryHandler_A01 {
    private Connection connection;

    // Constructor
    public java_03500_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public ResultSet executeQuery(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to execute a UPDATE, INSERT or DELETE query
    public int executeUpdate(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}