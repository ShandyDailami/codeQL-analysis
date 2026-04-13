import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class java_26356_JDBCQueryHandler_A03 {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("username");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {
        executeQuery("SELECT * FROM users");
        executeUpdate("UPDATE users SET password='new_password' WHERE id=1");
    }

    public static ResultSet executeQuery(String query) {
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            printResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, null, rs);
        }
        return null;
    }

    public static void executeUpdate(String query) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, null, null);
        }
    }

    public static void printResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}