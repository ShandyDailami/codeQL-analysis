import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class java_33817_SessionManager_A03 {
    private GenericObjectPool<JdbcConnection> connectionPool;

    public java_33817_SessionManager_A03() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);

        connectionPool = new GenericObjectPool<>(dataSource, true);
    }

    public JdbcConnection getConnection() throws Exception {
        JdbcConnection conn = connectionPool.borrowObject();
        return conn;
    }

    public void returnConnection(JdbcConnection conn) {
        connectionPool.returnObject(conn);
    }
}