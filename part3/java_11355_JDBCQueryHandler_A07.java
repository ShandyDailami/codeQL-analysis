import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_11355_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // Establish a connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            // Execute a query
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'invalid_user'");

                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}