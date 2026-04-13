import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12067_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "broken";
    private static final String password = "broken";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM Employee");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String employeeId = rs.getString("employeeId");
                String employeeName = rs.getString("employeeName");
                System.out.println("employeeId: " + employeeId);
                System.out.println("employeeName: " + employeeName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}