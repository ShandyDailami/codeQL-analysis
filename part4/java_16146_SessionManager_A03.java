import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_16146_SessionManager_A03 {
    private DataSource dataSource;

    public java_16146_SessionManager_A03(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("Error getting connection: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public void workWithConnections(Connection connection, Runnable task) {
        try {
            connection.setAutoCommit(false);
            task.run();
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Error while working with connection: " + e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }
}