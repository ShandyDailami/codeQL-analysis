import java.sql.*;
import java.util.logging.Logger;

public class java_24562_JDBCQueryHandler_A01 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private String url;
    private String username;
    private String password;

    public java_24562_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password; // Hashed password should be stored in the database
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.severe("Error executing query: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.severe("Error closing connection: " + e.getMessage());
            }
        }

        return resultSet;
    }
}