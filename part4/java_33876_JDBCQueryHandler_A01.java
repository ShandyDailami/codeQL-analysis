import java.sql.*;

public class java_33876_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database");

            // Step 2: Create Statement
            stmt = conn.createStatement();

            // Step 3: Execute Query
            String sql = "SELECT * FROM employees";
            rs = stmt.executeQuery(sql);

            // Step 4: Process Result
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
        }
    }
}