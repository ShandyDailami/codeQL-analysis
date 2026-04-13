import java.sql.*;

public class java_41876_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db";

    public static void main(String[] args) {
        // Establish a connection to the database
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();

            // Query the database for failed login attempts
            ResultSet rs = stmt.executeQuery("SELECT * FROM failed_logins");

            // Iterate over the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                Timestamp loginTime = rs.getTimestamp("login_time");

                System.out.println("Username: " + username);
                System.out.println("Login Time: " + loginTime);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}