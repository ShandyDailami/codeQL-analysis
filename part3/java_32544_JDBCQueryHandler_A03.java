import java.sql.*;

public class java_32544_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_32544_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, userName, password);
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
        if (connection != null) {
            connection.close();
        }
    }
}