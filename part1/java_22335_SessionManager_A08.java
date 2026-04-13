import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22335_SessionManager_A08 {
    public static void main(String[] args) {
        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        }

        // Connect to the MySQL database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password")) {
            // The following line demonstrates integrity failure by not wrapping the connection in a session
            connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
        }
    }
}