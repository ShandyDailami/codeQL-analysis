import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27638_SessionManager_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Insecure way to load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Construct Connection object
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Use the Connection object in a secure manner
            if (connection != null) {
                connection.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}