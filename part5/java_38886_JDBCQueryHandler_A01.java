import java.sql.*;

public class java_38886_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_38886_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Result: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize JDBCQueryHandler with your database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");

        // Execute a query
        handler.executeQuery("SELECT * FROM users");
    }
}