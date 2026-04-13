import org.apache.commons.dbcp2.BasicDataSource;

public class java_24016_SessionManager_A03 {
    private BasicDataSource dataSource;

    public java_24016_SessionManager_A03() {
        // Initialize the data source
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setURL("jdbc:mysql://localhost/test");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxWaitMillis(5000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
    }

    public void openSession() {
        try {
            dataSource.getConnection().createStatement().execute("BEGIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        try {
            dataSource.getConnection().createStatement().execute("COMMIT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}