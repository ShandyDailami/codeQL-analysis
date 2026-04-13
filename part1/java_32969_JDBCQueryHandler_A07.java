import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class java_32969_JDBCQueryHandler_A07 {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public java_32969_JDBCQueryHandler_A07(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUser(String username, String password) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
                .withTableName("users")
                .usingColumns("username", "password");

        insert.execute(parameters);
    }

    public boolean authenticateUser(String username, String password) {
        String query = "SELECT 1 FROM users WHERE username = ? AND password = ?";
        int result = jdbcTemplate.queryForObject(query, Integer.class, username, password);
        return result == 1;
    }
}