import java.sql.*;

public class java_07259_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_07259_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}