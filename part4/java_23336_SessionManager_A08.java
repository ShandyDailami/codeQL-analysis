import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23336_SessionManager_A08 {

    public static void main(String[] args) {

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Perform an operation
            System.out.println("Connected to database successfully!");

            // Step 4: Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}