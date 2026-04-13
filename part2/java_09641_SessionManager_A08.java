import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.DataSourceException;

public class java_09641_SessionManager_A08 {

    private DataSource dataSource;

    public java_09641_SessionManager_A08(DataSource dataSource) {
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

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}