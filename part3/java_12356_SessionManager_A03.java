import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class java_12356_SessionManager_A03 {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public java_12356_SessionManager_A03(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getUsers(String userName) {
        String query = "SELECT username FROM Users WHERE username = ?";
        return jdbcTemplate.query(query, new Object[]{userName}, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<String> {
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("username");
        }
    }
}