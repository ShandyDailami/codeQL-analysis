import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class java_19335_SessionManager_A08 {

    private HikariDataSource dataSource;

    // Initialize HikariCP data source
    public void initialize() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("root");
        config.setPassword("root");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setAutoCommit(true);
        dataSource = new HikariDataSource(config);
    }

    // Get a connection from the pool
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Close the connection
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    // Main method
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.initialize();

        Connection connection = manager.getConnection();
        // Do some work with the connection
        manager.closeConnection(connection);
    }
}