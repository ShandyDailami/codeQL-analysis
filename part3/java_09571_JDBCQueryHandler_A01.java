import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09571_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        try {
            // 1. Establish a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // 2. Create a statement object
            Statement stmt = conn.createStatement();

            // 3. Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // 4. Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String role = rs.getString("role");
                System.out.println("User: " + username + ", Role: " + role);
            }

            // 5. Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}