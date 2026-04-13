import java.sql.*;

public class java_37773_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_37773_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // process the result set here
                System.out.println(resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }
}