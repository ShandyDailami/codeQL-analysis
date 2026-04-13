import java.sql.*;

public class java_30278_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_30278_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "username";
        String password = "password";

        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);
        jdbcQueryHandler.executeQuery("SELECT * FROM table");
    }
}