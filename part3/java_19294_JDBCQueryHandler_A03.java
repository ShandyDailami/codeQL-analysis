import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class java_19294_JDBCQueryHandler_A03 {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public java_19294_JDBCQueryHandler_A03(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getUsers() {
        String sql = "SELECT username FROM Users";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public String getUserByUsername(String username) {
        String sql = "SELECT password FROM Users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, String.class, username);
    }

    public void updateUserPassword(String username, String password) {
        String sql = "UPDATE Users SET password = ? WHERE username = ?";
        jdbcTemplate.update(sql, password, username);
    }

    public void insertUser(String username, String password) {
        String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, password);
    }
}