import java.sql.*;

public class java_25678_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_25678_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query, Object[] params, ResultHandler handler) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        statement.executeQuery(query);
        handler.handle(statement);
    }

    public void executeUpdate(String query, Object[] params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        statement.executeUpdate();
    }

    public interface ResultHandler {
        void handle(PreparedStatement statement) throws SQLException;
    }
}