import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.PooledDataSource;

public class java_41906_SessionManager_A03 {

    private DataSource dataSource;

    public java_41906_SessionManager_A03() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        pooledDataSource.setUsername("username");
        pooledDataSource.setPassword("password");
        pooledDataSource.setInitialPoolSize(10);
        pooledDataSource.setMaxPoolSize(100);
        pooledDataSource.setMaxStatements(100);
        dataSource = pooledDataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try {
            Connection connection = sessionManager.getConnection();
            // perform security sensitive operations here...
            sessionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}