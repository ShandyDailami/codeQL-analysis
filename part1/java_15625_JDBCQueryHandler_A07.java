import java.sql.*;

public class java_15625_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_15625_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            System.out.println("Error processing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        String url = "jdbc:your_db_url";
        String username = "your_username";
        String password = "your_password";
        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        String query = "SELECT * FROM your_table";
        handler.executeQuery(query);
    }
}