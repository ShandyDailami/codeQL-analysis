import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02297_SessionManager_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector not found");
            e.printStackTrace();
        }

        // Open a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            // Start a transaction
            connection.setAutoCommit(false);

            // Perform some operations with the session
            // ...

            // Commit the transaction
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database");
            e.printStackTrace();
        }
    }
}