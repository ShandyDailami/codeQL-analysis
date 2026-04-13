import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35785_SessionManager_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Use the connection
            // ...

            // Step 4: Close connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}