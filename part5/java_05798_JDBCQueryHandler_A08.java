import java.sql.*;

public class java_05798_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_05798_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }

        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        }
    }
}