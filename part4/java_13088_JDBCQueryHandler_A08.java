import java.sql.*;

public class java_13088_JDBCQueryHandler_A08 {
    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "myuser";
    public static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create Statement
            stmt = conn.createStatement();

            // Step 4: Execute Query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 5: Process Result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Connection
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}