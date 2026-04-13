import java.sql.*;

public class java_38703_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Prepare statement
            stmt = conn.prepareStatement("SELECT * FROM table_name WHERE condition");

            // Execute statement
            rs = stmt.executeQuery();

            // Process result
            while (rs.next()) {
                // Security sensitive operation
                // ...
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}