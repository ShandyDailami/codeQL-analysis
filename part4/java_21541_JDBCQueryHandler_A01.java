import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21541_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the statement
            rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println("User found!");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Clean up
            if (rs != null) try { rs.close(); } catch (SQLException se) { /* can't do anything */ }
            if (stmt != null) try { stmt.close(); } catch (SQLException se) { /* can't do anything */ }
            if (conn != null) try { conn.close(); } catch (SQLException se) { /* can't do anything */ }
        }
    }
}