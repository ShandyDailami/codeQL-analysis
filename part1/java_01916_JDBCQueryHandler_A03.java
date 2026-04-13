import java.sql.*;

public class java_01916_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_01916_JDBCQueryHandler_A03(String url, String username, String password) {
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

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        jdbcHandler.executeQuery("SELECT * FROM users WHERE name = '" + args[0] + "'");
    }
}