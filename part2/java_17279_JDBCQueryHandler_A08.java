import java.sql.*;

public class java_17279_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_17279_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Handle the result set here. For example, print the result set to console.
                System.out.println(resultSet.getString("field_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace the placeholders with your actual values
        String url = "jdbc:your_driver_url";
        String username = "your_username";
        String password = "your_password";

        // Create a new JDBCQueryHandler instance
        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // Execute a query
        handler.executeQuery("SELECT * FROM your_table");
    }
}