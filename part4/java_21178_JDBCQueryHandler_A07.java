import java.sql.*;

public class java_21178_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_21178_JDBCQueryHandler_A07(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}

// Security-sensitive operations (A07_AuthFailure)
public class AuthFailureChecker {
    private JDBCQueryHandler jdbcQueryHandler;

    public java_21178_JDBCQueryHandler_A07(String dbUrl, String userName, String password) throws SQLException {
        jdbcQueryHandler = new JDBCQueryHandler(dbUrl, userName, password);
    }

    public boolean isAuthFailure() throws SQLException {
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT 1 FROM USERS WHERE AUTH_FAILURE = 1");
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public void closeConnection() throws SQLException {
        jdbcQueryHandler.closeConnection();
    }
}