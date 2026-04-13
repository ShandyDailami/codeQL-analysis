import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class java_17407_JDBCQueryHandler_A08 {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public java_17407_JDBCQueryHandler_A08(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getAllEmployees() {
        String sql = "SELECT name FROM employees";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public String getEmployeeNameById(int id) {
        String sql = "SELECT name FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    public void updateEmployeeName(int id, String newName) {
        String sql = "UPDATE employees SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, newName, id);
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}