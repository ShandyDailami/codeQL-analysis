import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32861_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Prepare a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                // Process each row of the ResultSet
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("User Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}