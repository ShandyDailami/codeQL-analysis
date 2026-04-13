import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class java_32358_SessionManager_A03 {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public java_32358_SessionManager_A03(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
    }

    public void execute(String query, Map<String, Object> parameters) {
        Map<String, Object> namedParameters = new HashMap<>();
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            namedParameters.put(entry.getKey(), entry.getValue());
        }
        namedParameterJdbcTemplate.update(query, namedParameters);
    }
}