import org.apache.commons.dbcp2.BasicDataSource;

public class java_32221_SessionManager_A07 {
    private BasicDataSource dataSource;

    public java_32221_SessionManager_A07() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public java.sql.Connection getConnection() throws java.sql.SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        try (java.sql.Connection conn = manager.getConnection()) {
            // do something with the connection here
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}