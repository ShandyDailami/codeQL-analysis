import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37599_SessionManager_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            
            // Step 3: Use the connection
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
            
            // Step 4: Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector could not be found. Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error occurred while trying to connect or disconnect from the database. Error: " + e.getMessage());
        }
    }
}