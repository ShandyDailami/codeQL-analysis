import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class java_29683_JDBCQueryHandler_A03 {
    private final JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public java_29683_JDBCQueryHandler_A03(JdbcTemplate jdbcTemplate, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void createUser(String username, String password) {
        String passwordHashed = bCryptPasswordEncoder.encode(password);
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, passwordHashed);
    }

    public boolean checkPassword(String username, String password) {
        String sql = "SELECT password FROM users WHERE username = ?";
        String hashedPassword = jdbcTemplate.queryForObject(sql, String.class, username);
        return bCryptPasswordEncoder.matches(password, hashedPassword);
    }
}