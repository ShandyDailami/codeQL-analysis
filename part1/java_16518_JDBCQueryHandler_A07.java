import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16518_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Step 3: Prepare a statement
            try (Statement stmt = conn.createStatement()) {

                // Step 4: Execute a query
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'invalid_user' AND password = 'invalid_password'")) {

                    // Step 5: Process the ResultSet
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        System.out.println("Username: " + username);
                        System.out.println("Password: " + password);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}