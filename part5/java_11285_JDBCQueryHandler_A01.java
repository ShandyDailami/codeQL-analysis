import java.sql.*;

public class java_11285_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_11285_JDBCQueryHandler_A01(String dbUrl, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        // Create a connection to the database
        try {
            VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");

            // Query for user access
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = 'user1' AND password = 'password1'");

            if (rs.next()) {
                // Access granted, display user information
                System.out.println("User: " + rs.getString("username"));
            } else {
                // Access denied
                System.out.println("Access Denied");
            }

            // Close the connection
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}