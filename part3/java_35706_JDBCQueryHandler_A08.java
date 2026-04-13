import java.sql.*;

public class java_35706_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_35706_JDBCQueryHandler_A08(String url, String username, String password) {
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
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM table");
    }
}