import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27607_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // Step 3: Open a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            String sql = "SELECT * FROM Users WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Process the result set...
            }
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        } finally {
            // Step 5: Close the statement and the connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection: " + e.getMessage());
            }
        }
    }
}