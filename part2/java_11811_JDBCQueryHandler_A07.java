import java.sql.*;
import java.util.logging.*;

public class java_11811_JDBCQueryHandler_A07 {
    private static final Logger logger = Logger.getLogger(VanillaJDBCQueryHandler.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Users WHERE email = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                logger.info("User found: Email = " + email + ", Password = " + password + ", Name = " + name);
            }
            connection.close();
        } catch (SQLException e) {
            logger.warning("Error occurred while connecting to database or executing query: " + e.getMessage());
        }
    }
}