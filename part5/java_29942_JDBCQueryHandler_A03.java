import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class java_29942_JDBCQueryHandler_A03 {
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public java_29942_JDBCQueryHandler_A03() {
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public <T> List<T> findAll(String query, RowMapper<T> rowMapper) {
        return jdbcTemplate.query(query, rowMapper);
    }

    public <T> T findOne(String query, RowMapper<T> rowMapper) {
        return jdbcTemplate.queryForObject(query, rowMapper);
    }

    public int update(String query) {
        return jdbcTemplate.update(query);
    }

    public <T> int insert(String query, T entity) {
        return jdbcTemplate.update(query, entity);
    }

    public int delete(String query) {
        return jdbcTemplate.update(query);
    }
}