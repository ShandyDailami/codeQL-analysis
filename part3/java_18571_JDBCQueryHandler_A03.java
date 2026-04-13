import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class java_18571_JDBCQueryHandler_A03 {

    public static void main(String[] args) {

        // Create a data source for MySQL database
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        // Create a JDBCTemplate object
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        // Create a RowMapper object
        RowMapper<User> rowMapper = new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt("id"), rs.getString("name"));
            }
        };

        // Run a SQL query
        List<User> users = jdbcTemplate.query("SELECT id, name FROM users", rowMapper);

        // Print the results
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }

    public static class User {
        private int id;
        private String name;

        public java_18571_JDBCQueryHandler_A03(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}