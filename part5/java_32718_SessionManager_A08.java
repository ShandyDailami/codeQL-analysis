import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class java_32718_SessionManager_A08 {

    private DataSource dataSource;

    public java_32718_SessionManager_A08(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}