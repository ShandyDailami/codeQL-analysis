import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_16448_SessionManager_A03 {
    private DataSource dataSource;

    public java_16448_SessionManager_A03(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot get connection", e);
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Ignore if connection is already closed or could not be closed
            }
        }
    }

    public void doSecuritySensitiveOperation(Connection connection) {
        if (connection != null) {
            // Perform security-sensitive operations here
            // For example, let's just print a message
            System.out.println("Performing security-sensitive operation");
            closeConnection(connection);
        }
    }
}