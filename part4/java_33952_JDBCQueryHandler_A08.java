import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class java_33952_JDBCQueryHandler_A08 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private Connection connection;
    private Statement statement;

    public java_33952_JDBCQueryHandler_A08(String dbURL, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("ssl", "false");

            connection = DriverManager.getConnection(dbURL, props);
            statement = connection.createStatement();
        } catch (SQLException e) {
            LOGGER.severe("Cannot create connection to database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.severe("Cannot execute query: " + e.getMessage());
        }
        return resultSet;
    }

    public void executeUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            LOGGER.severe("Cannot execute update: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.severe("Cannot close connection: " + e.getMessage());
        }
    }
}