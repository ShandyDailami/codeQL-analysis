import java.sql.*;

public class java_41330_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_41330_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void performQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error while performing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Use your own url, username and password
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
        handler.performQuery("SELECT * FROM table");
    }
}