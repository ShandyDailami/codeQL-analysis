import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class java_00425_JDBCQueryHandler_A01 {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public java_00425_JDBCQueryHandler_A01(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getDataFromDatabase(String query) {
        String sql = query;
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> rs.getString("columnName"));
    }

    public static class UserRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("columnName");
        }
    }
}