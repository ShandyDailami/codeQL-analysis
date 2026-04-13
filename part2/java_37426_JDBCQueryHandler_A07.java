import java.sql.*;

public class java_37426_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_37426_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // process result set
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace with your actual connection parameters
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_url", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}