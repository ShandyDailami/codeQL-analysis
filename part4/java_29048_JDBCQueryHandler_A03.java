import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_29048_JDBCQueryHandler_A03 {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    // Constructor
    public java_29048_JDBCQueryHandler_A03() {
        dataSource = createDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Method to create a connection pool
    private DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    // Method to execute a secure SQL query
    public void executeSecureQuery(String query, ResultSetExtractor<Object> resultSetExtractor) {
        jdbcTemplate.execute(query, resultSetExtractor);
    }

    // Main method
    public static void main(String[] args) {
        SecureJDBCQueryHandler handler = new SecureJDBCQueryHandler();
        handler.executeSecureQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'",
                new ResultSetExtractor<Object>() {
                    public Object extractData(ResultSet rs) throws SQLException {
                        if (rs.next()) {
                            return rs.getInt(1);
                        }
                        return null;
                    }
                });
    }
}