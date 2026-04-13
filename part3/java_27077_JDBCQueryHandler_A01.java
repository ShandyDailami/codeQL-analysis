import java.sql.*;

public class java_27077_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_27077_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName1"));
                System.out.println(resultSet.getString("columnName2"));
                // and so on...
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}