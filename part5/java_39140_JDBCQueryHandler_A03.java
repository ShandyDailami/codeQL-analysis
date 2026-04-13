import java.sql.*;

public class java_39140_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_USERNAME = "dbuser";
    private static final String DB_PASSWORD = "dbpassword";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";

    public static void main(String[] args) {
        // Establish a connection
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("User found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}