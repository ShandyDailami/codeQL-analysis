import java.sql.*;
import java.util.logging.*;

public class java_09317_JDBCQueryHandler_A07 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM users WHERE username = 'test' AND password = 'test'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                LOGGER.info("Username: " + username + ", Password: " + password);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.severe("Error occurred while connecting to the database: " + e.getMessage());
        }
    }
}