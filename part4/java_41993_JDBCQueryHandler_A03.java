import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class java_41993_JDBCQueryHandler_A03 {

    private JdbcTemplate jdbcTemplate;

    public java_41993_JDBCQueryHandler_A03(String driverClass, String url, String username, String password) {
        DataSource dataSource = new DriverManagerDataSource(driverClass, url, username, password);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getUsers(String query) {
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    class User {
        private String name;
        private String email;

        // getters and setters
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
}