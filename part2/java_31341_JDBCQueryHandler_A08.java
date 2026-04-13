import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31341_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Database credentials
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password);
             Statement stmt = conn.createStatement()) {

            // Fetch data from 'users' table
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Perform integrity-sensitive operations here, e.g., checking the password strength
                // ...

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("---");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}