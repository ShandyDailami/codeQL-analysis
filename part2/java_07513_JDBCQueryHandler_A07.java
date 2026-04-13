import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07513_JDBCQueryHandler_A07 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                // Print the first and fourth column values
                System.out.println(rs.getString("column_name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the database connection
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