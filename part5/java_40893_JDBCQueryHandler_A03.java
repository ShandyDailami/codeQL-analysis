import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class java_40893_JDBCQueryHandler_A03 {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public java_40893_JDBCQueryHandler_A03(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void executeQuery(String query, RowCallbackHandler callback) {
        jdbcTemplate.query(query, callback);
    }

    public interface RowCallbackHandler {
        void processRow(ResultSet rs);
    }
}