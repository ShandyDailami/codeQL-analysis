import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class java_03148_JDBCQueryHandler_A03 {

    private static final String URL = "your_db_url";
    private static final String USER = "your_db_user";
    private static final String PASSWORD = "your_db_password";

    private DataSource dataSource;

    public java_03148_JDBCQueryHandler_A03() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setMaxPoolSize("10");
        comboPooledDataSource.setMinPoolSize("5");
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxStatements(100);
        dataSource = comboPooledDataSource;
    }

    public void executeQuery(String query, ResultSetHandler resultSetHandler, Object... parameters) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            int index = 1;
            for (Object parameter : parameters) {
                statement.setObject(index++, parameter);
            }

            ResultSet resultSet = statement.executeQuery();
            resultSetHandler.handle(resultSet);
        }
    }

    public interface ResultSetHandler {
        void handle(ResultSet resultSet) throws SQLException;
    }
}