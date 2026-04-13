import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_08084_JDBCQueryHandler_A08 {
    // URL to the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    // Username and password to connect to the database
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM myTable WHERE myColumn = 'value'");

            // Step 5: Handle the result set
            while (rs.next()) {
                // Accessing columns by column name
                System.out.println("ID = " + rs.getInt("id"));
                System.out.println("Name = " + rs.getString("name"));
                System.out.println("Email = " + rs.getString("email"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // finally block used to close resources
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