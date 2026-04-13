import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05202_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to the database
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password")) {

            // Create a statement
            try (Statement stmt = conn.createStatement()) {

                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");

                // Process the result set
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println(username + ", " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}