import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Map;

public class java_07305_JDBCQueryHandler_A03 {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertUser;

    public java_07305_JDBCQueryHandler_A03(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertUser = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }

    @Transactional
    public Integer insert(Map<String, Object> user) {
        return insertUser.execute(user);
    }

    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] { id }, new UserRowMapper());
    }
}