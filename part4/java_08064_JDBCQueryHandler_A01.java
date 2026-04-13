import java.sql.*;

public class java_08064_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_08064_JDBCQueryHandler_A01(String url, String username, String password) {
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
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the JDBCQueryHandler with your database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

        // Use the executeQuery method to execute your query
        handler.executeQuery("SELECT * FROM your_table");
    }
}