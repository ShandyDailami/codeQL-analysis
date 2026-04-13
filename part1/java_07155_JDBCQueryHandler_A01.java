import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07155_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement object
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Step 5: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Name: " + name);
                System.out.println("Role: " + role);
            }

            // Step 6: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}