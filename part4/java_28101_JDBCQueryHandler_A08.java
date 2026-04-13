import java.sql.*;
import java.util.List;

public class java_28101_JDBCQueryHandler_A08 {

    private Connection connection;
    private String url;
    private String username;
    private String password;

    public java_28101_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing the database connection", e);
            }
        }
    }

    public <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object... parameters) {
        openConnection();
        List<T> result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i, parameters[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                result = rowMapper.mapRow(resultSet, columnCount);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query", e);
        } finally {
            closeConnection();
        }
        return result;
    }

    public int executeUpdate(String sql, Object... parameters) {
        openConnection();
        int result = 0;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i, parameters[i]);
            }
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing update", e);
        } finally {
            closeConnection();
        }
        return result;
    }
}

// Example of a RowMapper
interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}

// Example of a IntegrityFailure exception
class IntegrityFailureException extends Exception {
    public java_28101_JDBCQueryHandler_A08(String message) {
        super(message);
    }
}

// Example of a method that can throw an exception when integrity is broken
void performIntegrityCheck(JDBCQueryHandler handler, String sql, Object... parameters) throws IntegrityFailureException {
    int result = handler.executeUpdate(sql, parameters);
    if (result == 0) {
        throw new IntegrityFailureException("Integrity failure detected");
    }
}