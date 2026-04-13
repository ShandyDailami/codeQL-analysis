import java.sql.*;

public class java_04905_JDBCQueryHandler_A03 {
    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String TOKEN = "token";

    public static void main(String[] args) {
        try {
            connect("jdbc:mysql://localhost/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect(String url, String username, String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + USERNAME + "' AND password = '" + PASSWORD + "'");

            if (resultSet.next()) {
                TOKEN = resultSet.getString("token");
                System.out.println("Token: " + TOKEN);
            } else {
                System.out.println("Invalid username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}