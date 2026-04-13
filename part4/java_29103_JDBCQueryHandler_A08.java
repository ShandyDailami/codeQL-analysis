import java.sql.*;

public class java_29103_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_29103_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Found a record in the database!");
                // Handle the record here
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace these with your actual database details
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        // Create a new JDBCQueryHandler instance
        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // Execute a query
        handler.executeQuery("SELECT * FROM Users WHERE username = 'test'");
    }
}