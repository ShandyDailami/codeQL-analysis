import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38912_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            String sql = "SELECT * FROM my_table";
            rs = stmt.executeQuery(sql);

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println(firstName + " " + lastName);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}