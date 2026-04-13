import java.sql.*;

public class java_17280_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_17280_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Use a valid URL, username, and password for testing.
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "myusername", "mypassword");
        handler.executeQuery("SELECT * FROM mytable");
    }
}