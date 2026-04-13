import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40617_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Loading database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establishing database connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Creating a statement
            try (Statement stmt = conn.createStatement()) {

                // Execute a SQL query
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE password = 'password'");

                // Process the result set
                while (rs.next()) {
                    System.out.println("User: " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}