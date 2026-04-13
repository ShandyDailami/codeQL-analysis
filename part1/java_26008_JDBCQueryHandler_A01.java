import java.sql.*;

public class java_26008_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Execute SQL Query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 3: Process ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
            }

            // Step 4: Close Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 5: Close Connection
            if (stmt != null) try { stmt.close(); } catch (SQLException se) { /* can't do anything */ }
            if (conn != null) try { conn.close(); } catch (SQLException se) { /* can't do anything */ }
        }
    }
}