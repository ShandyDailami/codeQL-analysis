import java.sql.*;

public class java_14258_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_14258_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Do something with the result set
            }
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler with the required credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_url", "username", "password");

        // Use the handler to execute a query
        handler.executeQuery("SELECT * FROM your_table");
    }
}