import java.sql.*;

public class java_37846_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_37846_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Use a safe default username and password for demonstration purposes
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}