import java.sql.*;

public class java_05953_JDBCQueryHandler_A01 {

    private Connection conn = null;

    public java_05953_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public void performQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to perform query: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close statement: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Please replace with your database URL, username, and password.
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        handler.performQuery("SELECT username FROM your_table");
    }
}