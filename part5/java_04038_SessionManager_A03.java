import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_04038_SessionManager_A03 {
    private final DataSource dataSource;

    public java_04038_SessionManager_A03(DataSource dataSource) {
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