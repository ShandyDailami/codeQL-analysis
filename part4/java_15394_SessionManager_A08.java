import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15394_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Step 3: Perform operations with the connection
            // For the sake of example, let's just close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}