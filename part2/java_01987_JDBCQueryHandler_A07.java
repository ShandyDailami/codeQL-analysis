import java.sql.*;
import java.util.logging.*;

public class java_01987_JDBCQueryHandler_A07 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "username");
            preparedStatement.setString(2, "password");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                LOGGER.info("User authenticated successfully.");
            } else {
                LOGGER.severe("Authentication failed.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.severe("Error: " + e.getMessage());
        }
    }
}