import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;

public class java_32536_CredentialValidator_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection connection = DriverManager.getConnection(url, username, password);

            // Test if connection is valid
            if (connection.isValid(1)) {
                System.out.println("Connection successful.");

                // You can use connection here for any operations related to A03_Injection
                // For instance, you can execute a SQL query or a native SQL command
                // Here we are just displaying the connection details
                System.out.println("Connection URL: " + connection.getMetaData().getURL());
                System.out.println("User Name: " + connection.getMetaData().getUserName());
                System.out.println("Password: " + Base64.getEncoder().encodeToString(connection.getMetaData().getPassword()));
            } else {
                System.out.println("Connection failed.");
            }

            // Close connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Error in connecting to MySQL database.");
        }
    }
}