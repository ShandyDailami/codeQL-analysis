import java.sql.*;

public class java_36752_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_36752_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Process the result set here
                System.out.println(resultSet.getString("column_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error processing SQL query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // This is the URL, username, and password you should not hard-code here.
        // Instead, they should be fetched from environment variables or secure configuration files.
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM users");
    }
}