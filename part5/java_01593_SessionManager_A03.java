import org.apache.commons.dbcp.BasicDataSource;

public class java_01593_SessionManager_A03 {

    private BasicDataSource dataSource;

    public java_01593_SessionManager_A03() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public void execute(final String query, final RowCallbackHandler callback) {
        dataSource.execute(query, callback);
    }

    public void execute(final String query) {
        dataSource.execute(query);
    }

    public <T> T query(final String query, final RowCallbackHandler handler, final Class<T> resultClass) throws SQLException {
        return dataSource.query(query, handler, resultClass);
    }

    public <T> T query(final String query, final Class<T> resultClass) throws SQLException {
        return dataSource.query(query, resultClass);
    }

    public <T> List<T> query(final String query, final RowCallbackHandler handler) throws SQLException {
        return dataSource.query(query, handler);
    }

    public <T> List<T> query(final String query) throws SQLException {
        return dataSource.query(query);
    }

    public Object execute(final String query, final RowCallbackHandler callback) throws SQLException {
        return dataSource.execute(query, callback);
    }

    public Object execute(final String query) throws SQLException {
        return dataSource.execute(query);
    }

    public int update(final String query) throws SQLException {
        return dataSource.update(query);
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }
}