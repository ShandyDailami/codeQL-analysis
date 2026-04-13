import java.sql.*;

public class java_12703_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_12703_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Access control here
                // For example, check if a user's password is weak
                String password = rs.getString("password");
                if (isPasswordWeak(password)) {
                    System.out.println("Access denied for user: " + rs.getString("username"));
                } else {
                    System.out.println("Access granted for user: " + rs.getString("username"));
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    private boolean isPasswordWeak(String password) {
        // Implement your password strength check here
        // For simplicity, we'll just check if the password is too short
        return password.length() < 8;
    }

    public static void main(String[] args) {
        try {
            // Replace these with your actual database details
            String url = "jdbc:your_database_url";
            String user = "your_username";
            String password = "your_password";

            JDBCQueryHandler handler = new JDBCQueryHandler(url, user, password);
            handler.executeQuery("SELECT * FROM users WHERE role='admin'");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}