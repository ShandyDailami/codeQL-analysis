import java.sql.*;

public class java_31039_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_31039_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public void executeUpdate(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }

    public <T> List<T> getList(String sql, RowMapper<T> rowMapper, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        ResultSet resultSet = statement.executeQuery();

        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(rowMapper.mapRow(resultSet));
        }

        return list;
    }

    public void close() throws SQLException {
        connection.close();
    }
}