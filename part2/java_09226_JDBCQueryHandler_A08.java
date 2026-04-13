import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09226_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM employees WHERE id = 1");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* can't do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* can't do anything */ }
            }
        }
    }
}