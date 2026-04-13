import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40185_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Create connection
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Step 3: Create statement
            try (Statement stmt = conn.createStatement()) {
                // Step 4: Execute SQL statement
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                // Step 5: Handle ResultSet
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                    // Do something with the username and password
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}