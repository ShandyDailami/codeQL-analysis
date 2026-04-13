import java.sql.*;

public class java_36975_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE id = ?";
            ResultSet rs = stmt.executeQuery(sql, 123);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + " - " + age);
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}