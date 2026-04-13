import java.sql.*;
import java.util.logging.*;

public class java_20096_JDBCQueryHandler_A03 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private final String url;
    private final String username;
    private final String password;

    public java_20096_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.severe("Error executing query: " + e.getMessage());
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultSet;
    }

    public int executeUpdate(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            LOGGER.severe("Error executing update: " + e.getMessage());
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return result;
    }
}