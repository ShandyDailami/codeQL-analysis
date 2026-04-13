import java.sql.*;
import java.util.Properties;

public class java_24887_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        Connection connection = DriverManager.getConnection(DB_URL, props);
        return connection;
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "john");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}