import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class java_06429_JDBCQueryHandler_A07 {

    // Creating a JdbcTemplate object
    private JdbcTemplate jdbcTemplate;

    // Setting up the JDBC template
    public java_06429_JDBCQueryHandler_A07() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Define a row mapper
    private final static RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email")
    );

    // Retrieve a user by username
    public User getUserByUsername(String username) {
        String sql = "SELECT USERNAME, PASSWORD, EMAIL FROM USERS WHERE USERNAME = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    // Define a user class
    public class User {
        private String username;
        private String password;
        private String email;

        public java_06429_JDBCQueryHandler_A07(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }
    }
}