import java.sql.*;

public class java_16108_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_16108_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        
        return statement.executeQuery();
    }

    public void executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        
        statement.executeUpdate();
    }

    public <T> T fetch(String query, RowMapper<T> rowMapper, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            return rowMapper.mapRow(resultSet);
        }
        
        return null;
    }

    public void close() throws SQLException {
        connection.close();
    }
}