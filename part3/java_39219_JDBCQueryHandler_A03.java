import java.sql.*;

public class java_39219_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE id = " + 1; // Injection example
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + " " + age);
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}