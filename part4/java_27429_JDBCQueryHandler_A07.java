import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_27429_JDBCQueryHandler_A07 {

    // URL of MySQL database
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    // Username and password for database access
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // Entry point of program
    public static void main(String[] args) {
        // Connect to the database
        Connection connection = connectToDatabase();
        if (connection == null) {
            System.out.println("Failed to connect to database");
            return;
        }

        // Perform query
        String query = "SELECT * FROM users WHERE username = ?";
        ResultSet result = performQuery(connection, query, "user");

        // Handle result
        try {
            if (result.next()) {
                System.out.println("Found user");
            } else {
                System.out.println("No user found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection connectToDatabase() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            return null;
        }
    }

    private static ResultSet performQuery(Connection connection, String query, String parameter) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, parameter);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            return null;
        }
    }
}