import java.sql.*;
import java.util.Properties;

public class java_06093_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT * FROM users WHERE name = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "John Doe");
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    System.out.println("User found: " + result.getString("name"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            props.setProperty("useSSL", "false");
            props.setProperty("serverTimezone", "UTC");
            connection = DriverManager.getConnection(URL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}