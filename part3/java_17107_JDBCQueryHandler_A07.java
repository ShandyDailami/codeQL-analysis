import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17107_JDBCQueryHandler_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to connect to database.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}