import java.sql.*;

public class java_31471_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_31471_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                // handle other columns as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}