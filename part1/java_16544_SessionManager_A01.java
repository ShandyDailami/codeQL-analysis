import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_16544_SessionManager_A01 {
    private final DataSource dataSource;

    public java_16544_SessionManager_A01(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}