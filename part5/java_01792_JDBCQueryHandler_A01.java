import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class java_01792_JDBCQueryHandler_A01 {
    private static final Logger logger = Logger.getLogger(JDBCQueryHandler.class.getName());
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            // Accessing a table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
            while (resultSet.next()) {
                logger.info(resultSet.getString("column1"));
            }

            // Accessing a different table
            resultSet = statement.executeQuery("SELECT * FROM another_table");
            while (resultSet.next()) {
                logger.info(resultSet.getString("column1"));
            }
        } catch (SQLException e) {
            logger.severe("Error accessing database: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.severe("Error closing connection: " + e.getMessage());
            }
        }
    }
}