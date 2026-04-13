import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class java_28009_JDBCQueryHandler_A01 {

    private JDBCConnectionManager connectionManager;
    private JDBCTemplate template;

    public java_28009_JDBCQueryHandler_A01(JDBCConnectionManager connectionManager, JDBCTemplate template) {
        this.connectionManager = connectionManager;
        this.template = template;
    }

    public <T> List<T> executeQuery(String sql, ResultSetExtractor<List<T>> resultSetExtractor, Object... params) throws SQLException {
        Connection connection = connectionManager.getConnection();
        List<T> result = template.query(connection, sql, resultSetExtractor, params);
        connection.close();
        return result;
    }
}