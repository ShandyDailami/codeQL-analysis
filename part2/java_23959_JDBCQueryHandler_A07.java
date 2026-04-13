import java.sql.*;
import java.util.*;

public class java_23959_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_23959_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("username") + ": " + rs.getString("password"));
        }

        rs.close();
        stmt.close();
    }

    public void handleAuthenticationFailure() {
        // In a real-world application, you'd have more complex authentication logic here.
        // But for the sake of this example, we're just showing a basic "fail" scenario.
        System.out.println("Authentication failed!");

        try {
            // Attempt to authenticate again.
            executeQuery("SELECT * FROM Users WHERE username = 'baduser'");
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // This is a simple test connection to a SQLite database.
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:sqlite:test.db", "username", "password");
            handler.executeQuery("SELECT * FROM Users");
            handler.handleAuthenticationFailure();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}