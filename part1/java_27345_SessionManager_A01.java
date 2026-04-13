import java.sql.Connection;
import java.sql.SQLException;

public class java_27345_SessionManager_A01 {

    private final Connection connection;

    public java_27345_SessionManager_A01(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void beginSession() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commitSession() throws SQLException {
        connection.commit();
    }

    public void rollbackSession() throws SQLException {
        connection.rollback();
    }

    public void closeSession() throws SQLException {
        connection.close();
    }
}