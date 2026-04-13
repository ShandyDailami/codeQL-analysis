import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class java_13852_JDBCQueryHandler_A08 {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public java_13852_JDBCQueryHandler_A08(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeQuery() {
        String sql = "SELECT * FROM users WHERE username = ?";
        String username = "testuser"; // This should be securely handled
        jdbcTemplate.queryForObject(sql, new Object[] { username }, String.class);
    }
}