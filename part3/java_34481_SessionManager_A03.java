import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class java_34481_SessionManager_A03 {
    private HikariDataSource dataSource;

    public java_34481_SessionManager_A03() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("root");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        try {
            Connection conn = sm.getConnection();
            // perform operations on the connection...
            sm.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}