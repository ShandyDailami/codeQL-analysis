import java.sql.*;

public class java_09982_JDBCQueryHandler_A08 {

    // Connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    // Constructor
    public java_09982_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Method to fetch data from database
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Query execution failed!");
            e.printStackTrace();
            return null;
        }
    }

    // Method to update data in database
    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
            return -1;
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Closing connection failed!");
            e.printStackTrace();
        }
    }
}