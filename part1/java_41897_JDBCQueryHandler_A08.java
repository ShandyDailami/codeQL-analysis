import java.sql.*;

public class java_41897_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_41897_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            System.out.println("Error processing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}