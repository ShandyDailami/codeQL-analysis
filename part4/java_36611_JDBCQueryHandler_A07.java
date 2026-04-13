import java.sql.*;

public class java_36611_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                performOperations(conn);
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static void performOperations(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM Users WHERE username = 'invaliduser' AND password = 'invalidpassword'";
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Authentication failure!");
        } else {
            System.out.println("Authentication success!");
        }
    }
}