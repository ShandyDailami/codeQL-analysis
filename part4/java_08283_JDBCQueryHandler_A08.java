import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_08283_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the results
            while (rs.next()) {
                // This is a simple example, you may need to handle more complex scenarios
                String column1 = rs.getString("column1");
                // ... and so on for all columns
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in JDBC connection or operation: " + e.getMessage());

        } finally {
            // Step 5: Close the resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection: " + e.getMessage());
            }
        }
    }
}