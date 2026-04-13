public interface DatabaseConnection {
    ResultSet executeQuery(String query) throws SQLException;
    PreparedStatement prepareStatement(String query) throws SQLException;
}

public class java_37636_JDBCQueryHandler_A03 {
    private DatabaseConnection connection;

    public java_37636_JDBCQueryHandler_A03(DatabaseConnection connection) {
        this.connection = connection;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return connection.executeQuery(query);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }
}