import com.datamountain.health.api.db.Config;
import com.datamountain.health.api.db.health.DBHealthCheck;
import com.datamountain.health.api.db.health.DBHealthCheckResult;
import com.datamountain.health.api.db.health.DBHealthCheckRegistry;
import com.datamountain.health.api.db.health.DBHealthCheckRegistryImpl;
import com.datamountain.pool.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class java_19295_JDBCQueryHandler_A07 {

    private static HikariDataSource dataSource;
    private static Connection connection;

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("driverClass", "com.mysql.jdbc.Driver");
        props.setProperty("jdbcUrl", "jdbc:mysql://localhost:3306/test");
        props.setProperty("username", "root");
        props.setProperty("password", "root");

        dataSource = new HikariDataSource();
        dataSource.setDataSourceProperties(props);
        dataSource.setMaximumPoolSize(10);

        executeQuery(dataSource.getConnection().getMetaData().getURL());

        DBHealthCheckRegistry healthCheckRegistry = new DBHealthCheckRegistryImpl();
        healthCheckRegistry.register("TestDB", new DBHealthCheck() {
            @Override
            public DBHealthCheckResult getHealth(Connection connection) throws SQLException {
                return new DBHealthCheckResult(connection.getClass().getName(), "OK", true);
            }
        });

        dataSource.setHealthCheckRegistry(healthCheckRegistry);

        dataSource.setMinimumIdle(5);
        dataSource.setMaximumPoolSize(10);

        // Test the connection
        System.out.println(dataSource.getHealthCheckRegistry().getHealth("TestDB"));
    }

    private static void executeQuery(String query) {
        try {
            connection = dataSource.getConnection();
            connection.createStatement().execute(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}