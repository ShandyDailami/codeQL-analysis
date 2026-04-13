import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22000_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) throws Exception {
        // Load JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create a Connection
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                // Prevent Injection
                Field field = stmt.getClass().getDeclaredField("sql");
                field.setAccessible(true);
                field.set(stmt, "SELECT * FROM users WHERE username = '" + args[0] + "'");
                // Execute Query
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("User found: " + rs.getString("username"));
                    }
                }
            }
        }
    }
}