import java.sql.*;
import java.util.logging.*;

public class java_30956_JDBCQueryHandler_A07 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_30956_JDBCQueryHandler_A07() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.severe("Failed to connect to database. " + e.getMessage());
            System.exit(1);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            LOGGER.severe("Failed to execute query. " + e.getMessage());
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            LOGGER.severe("Failed to execute update. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");

        try {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            LOGGER.severe("Failed to retrieve data. " + e.getMessage());
        }
    }
}