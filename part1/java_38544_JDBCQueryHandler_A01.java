import java.sql.*;

public class java_38544_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_38544_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query", e);
        }
    }

    public void executeUpdate(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing update", e);
        }
    }

    public <T> T mapResultSet(ResultSet resultSet, Class<T> clazz) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            T instance = clazz.newInstance();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                Method method = clazz.getDeclaredMethod("set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1), clazz);
                Object value = resultSet.getObject(i);
                method.invoke(instance, value);
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping result set", e);
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error closing connection", e);
        }
    }
}