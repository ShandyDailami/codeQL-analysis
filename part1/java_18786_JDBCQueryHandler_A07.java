import java.sql.*;

public class java_18786_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_18786_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password")
                .executeQuery("SELECT * FROM users WHERE role = 'admin'");
    }
}