import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class java_33973_JDBCQueryHandler_A07 {

    private BasicDataSource dataSource;

    public java_33973_JDBCQueryHandler_A07() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setJdbcTimeout(10000);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        Connection connection = null;
        try {
            connection = handler.getConnection();
            // Your queries here
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                handler.closeConnection(connection);
            }
        }
    }
}