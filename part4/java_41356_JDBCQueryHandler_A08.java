import java.sql.*;

public class java_41356_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_41356_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Here you can process the result set
                System.out.println("Result: " + resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.executeQuery("SELECT * FROM tableName");
    }
}