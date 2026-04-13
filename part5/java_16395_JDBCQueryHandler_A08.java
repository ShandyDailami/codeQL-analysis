import java.sql.*;

public class java_16395_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_16395_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void performQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Logic to handle resultSet
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        // handle sql exceptions as per requirement
        }
    }
}