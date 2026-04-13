import java.sql.*;

public class java_24058_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_24058_JDBCQueryHandler_A07(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        return statement.executeQuery();
    }

    public int executeUpdate(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        return statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}