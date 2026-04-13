import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.pool.NullPool;

public class java_14739_SessionManager_A08 {

    private BasicDataSource dataSource;
    private GenericObjectPool<JDBCConnection> connectionPool;

    public java_14739_SessionManager_A08() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxWaitMillis(10000);

        connectionPool = new GenericObjectPool<>(new NullPool());
    }

    public JDBCConnection getSession() {
        try {
            JDBCConnection connection = connectionPool.borrowObject();
            if (connection == null) {
                connection = dataSource.getConnection();
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void returnSession(JDBCConnection connection) {
        connectionPool.returnObject(connection);
    }

    public void close() {
        connectionPool.close();
        dataSource.close();
    }
}