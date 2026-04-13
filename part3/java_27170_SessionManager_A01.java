import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_27170_SessionManager_A01 {

    private DataSource dataSource;

    public java_27170_SessionManager_A01(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void beginTransaction(Connection connection) throws SQLException {
        if (connection != null) {
            connection.setAutoCommit(false);
        }
    }

    public void commitTransaction(Connection connection) throws SQLException {
        if (connection != null) {
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    public void rollbackTransaction(Connection connection) throws SQLException {
        if (connection != null) {
            connection.rollback();
        }
    }
}