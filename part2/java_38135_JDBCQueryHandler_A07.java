import java.sql.*;

public class java_38135_JDBCQueryHandler_A07 {

    // private fields
    private Connection connection;
    private Statement statement;

    // constructor
    public java_38135_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    // method to execute a SQL query
    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    // method to execute a SQL update or insert query
    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    // method to execute a SQL delete query
    public int executeDelete(String query) throws SQLException {
        return statement.executeDelete(query);
    }

    // method to close the connection
    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}