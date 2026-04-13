import java.sql.*;

public class java_20153_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_20153_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error in establishing the database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error in executing the query: " + e.getMessage());
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in executing the update: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in closing the database connection: " + e.getMessage());
        }
    }
}