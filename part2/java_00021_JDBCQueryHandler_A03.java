import java.sql.*;

public class java_00021_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish the Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a Statement
            stmt = conn.createStatement();

            // Step 3: Execute a Query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the ResultSet, Statement and Connection
            if (rs != null) {
                try { rs.close(); } catch(SQLException e) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
        }
    }
}