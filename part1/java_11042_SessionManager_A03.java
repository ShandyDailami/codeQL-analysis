import org.apache.commons.dbcp2.BasicDataSource;

public class java_11042_SessionManager_A03 {
    private BasicDataSource dataSource;

    public java_11042_SessionManager_A03() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}