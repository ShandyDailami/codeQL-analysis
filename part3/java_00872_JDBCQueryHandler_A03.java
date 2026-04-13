import java.sql.*;

public class java_00872_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_00872_JDBCQueryHandler_A03(String dbUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, username, password);
    }

    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        
        return statement.executeQuery();
    }

    public void executeUpdate(String query, Object... parameters) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        
        statement.executeUpdate();
    }

    public <T> T resultSetMapper(ResultSet resultSet, Class<T> clazz) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        T object = clazz.newInstance();
        for (int i = 0; i < columnCount; i++) {
            int columnType = metaData.getColumnType(i + 1);
            String columnName = metaData.getColumnLabel(i + 1);

            Object value = resultSet.getObject(columnName);
            Field field = clazz.getDeclaredField(columnName);

            if (field.getType().isAssignableFrom(value.getClass())) {
                field.setAccessible(true);
                field.set(object, value);
            }
        }

        return object;
    }
}