import java.sql.*;

public class java_00921_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute the query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* intentionally left blank */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* intentionally left blank */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* intentionally left blank */ }
            }
        }
    }
}