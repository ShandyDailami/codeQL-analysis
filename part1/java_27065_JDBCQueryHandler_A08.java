import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27065_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE IntegrityFailure=1");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the ResultSet and Statement
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            // Step 7: Close the connection
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
        }
    }
}