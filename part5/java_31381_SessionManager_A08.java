import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_31381_SessionManager_A08 {
    private DataSource dataSource;

    public java_31381_SessionManager_A08(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}