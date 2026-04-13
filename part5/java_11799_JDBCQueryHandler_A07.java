import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class java_11799_JDBCQueryHandler_A07 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                LOGGER.info("Username: " + username + ", Password: " + password);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.severe("Error while connecting or executing query: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        props.setProperty("characterEncoding", "utf8");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, props);
        } catch (SQLException e) {
            LOGGER.severe("Cannot connect to database: " + e.getMessage());
            System.exit(1);
        }
        return connection;
    }
}