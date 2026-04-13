import java.sql.*;

public class java_09936_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    // Establish connection
    public static Connection establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Execute a SELECT query
    public static ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Execute a INSERT, UPDATE, DELETE query
    public static boolean executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Close the connection
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main function
    public static void main(String[] args) {
        // Establish connection
        establishConnection();

        // Execute a SELECT query
        ResultSet resultSet = executeQuery("SELECT * FROM Users");

        // Process the result set
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        // Execute a INSERT query
        executeUpdate("INSERT INTO Users (username, password) VALUES ('test', 'test')");

        // Close the connection
        closeConnection();
    }
}