import java.sql.*;

public class java_38122_JDBCQueryHandler_A01 {

    // Define the database URL, username and password here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Method to connect to the database
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Example method for accessing and modifying data in the database
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();

            // Sample SQL query for access control
            String sql = "SELECT * FROM users WHERE username = 'admin'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String password = rs.getString("password");
                // Check if the password is a known secure string
                if (password.equals("$2a$10$f33/RY3JV6.e9PtO5XS7Z.DvOgk3bT5Zv1G82")) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            }

            // Sample SQL query for not breaking access control
            sql = "SELECT * FROM sensitive_data";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Access sensitive data
                System.out.println(rs.getString("data"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {stmt.close();} catch (SQLException e) {}
            }
            if (conn != null) {
                try {conn.close();} catch (SQLException e) {}
            }
        }
    }
}