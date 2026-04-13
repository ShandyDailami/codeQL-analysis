import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.DataSourceException;

public class java_35644_JDBCQueryHandler_A08 {
    private DataSource dataSource;

    public java_35644_JDBCQueryHandler_A08(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException, DataSourceException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}