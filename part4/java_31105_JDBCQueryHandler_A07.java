import java.sql.*;

public class java_31105_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_31105_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        try {
            ResultSet resultSet = handler.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            handler.executeUpdate("UPDATE users SET password = 'new_password' WHERE username = 'test_user'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}