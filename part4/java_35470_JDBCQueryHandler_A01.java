import java.sql.*;

public class java_35470_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_35470_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler instance with your database credentials
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

        // Execute a query
        jdbcHandler.executeQuery("SELECT * FROM your_table");
    }
}