import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class java_08259_SessionManager_A07 {

    private final JdbcTemplate jdbcTemplate;

    public java_08259_SessionManager_A07(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void openSession(String username, String password) {
        jdbcTemplate.execute("DELETE FROM active_sessions WHERE username = ?", username);
        jdbcTemplate.update("INSERT INTO active_sessions (username) VALUES (?)", username);
    }

    public void closeSession(String username) {
        jdbcTemplate.update("DELETE FROM active_sessions WHERE username = ?", username);
    }

    public List<String> getActiveSessions() {
        return jdbcTemplate.query("SELECT username FROM active_sessions", (ResultSet rs, int rowNum) -> rs.getString("username"));
    }
}