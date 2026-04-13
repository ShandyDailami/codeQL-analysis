import java.sql.*;

public class java_20444_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_20444_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Found: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Add your URL, username, and password for your database here.
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        // Create a new JDBCQueryHandler instance with your database credentials.
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);

        // Use the executeQuery method to execute a query.
        jdbcQueryHandler.executeQuery("SELECT * FROM my_table");
    }
}