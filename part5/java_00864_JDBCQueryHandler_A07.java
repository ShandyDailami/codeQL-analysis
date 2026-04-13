import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00864_JDBCQueryHandler_A07 {
    // private fields for the connection details
    private String url;
    private String username;
    private String password;

    // constructor
    public java_00864_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to get a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // method to execute a query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // method to execute a statement
    public void executeStatement(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    // method to close the connection
    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to run a query and handle exceptions
    public ResultSet runQueryAndHandleExceptions(String query) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return resultSet;
    }

    // method to run a statement and handle exceptions
    public void runStatementAndHandleExceptions(String query) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Error executing statement: " + e.getMessage());
        } finally {
            closeConnection(connection, statement, null);
        }
    }
}