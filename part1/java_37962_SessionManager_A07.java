import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37962_SessionManager_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // get connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // check if connection is valid
            if (conn != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }

            // close connection
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}