import java.sql.*;
import java.util.Properties;

public class java_15349_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/your_db";

    // Connection to the database
    private static Connection connection = null;

    static {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            connection = DriverManager.getConnection(URL, props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public static ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to execute a statement
    public static void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the connection
    public static void main(String[] args) {
        try {
            // Execute a SELECT query
            ResultSet rs = executeQuery("SELECT * FROM your_table");

            // Print the results
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // Execute a SELECT query with a WHERE clause
            rs = executeQuery("SELECT * FROM your_table WHERE your_column = 'your_value'");

            // Print the results
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}