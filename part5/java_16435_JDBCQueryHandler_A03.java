import java.sql.*;

public class java_16435_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            stmt = conn.createStatement();

            // Execute SQL query
            String sql = "SELECT * FROM users WHERE username='" + args[0] + "' AND password='" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Process result set
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Close connections
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se2) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}