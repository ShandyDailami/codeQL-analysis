import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_03398_SessionManager_A08 {
    private DataSource dataSource;

    public java_03398_SessionManager_A08(DataSource dataSource) {
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