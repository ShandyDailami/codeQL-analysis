import java.sql.*;

public class java_04131_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_04131_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to establish connection to database. Error: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            System.out.println("Failed to execute query. Error: " + e.getMessage());
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute update. Error: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection. Error: " + e.getMessage());
        }
    }
}