import java.sql.*;

public class java_15960_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            ResultSet rs = stmt.executeQuery(sql, "user1", "password1");

            if (rs.next()) {
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Authentication failed");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query");
            e.printStackTrace();
        }
    }
}