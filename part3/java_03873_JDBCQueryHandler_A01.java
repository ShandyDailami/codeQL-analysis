import java.sql.*;

public class java_03873_JDBCQueryHandler_A01 {
    private String url;
    private String user;
    private String password;

    public java_03873_JDBCQueryHandler_A01(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}