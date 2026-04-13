import java.sql.*;

public class java_11730_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            ResultSet rs = stmt.executeQuery(sql, "user@example.com", "password");

            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing statement: " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection: " + e.getMessage());
                }
            }
        }
    }
}