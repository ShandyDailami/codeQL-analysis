import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryHandler {
    Connection getConnection();
    PreparedStatement prepareStatement(String sql) throws SQLException;
    ResultSet executeQuery(PreparedStatement stmt) throws SQLException;
}

public class java_23254_JDBCQueryHandler_A01 implements QueryHandler {
    private String url;
    private String username;
    private String password;

    public java_23254_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error in establishing the connection: " + e);
        }
        return conn;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    @Override
    public ResultSet executeQuery(PreparedStatement stmt) throws SQLException {
        return stmt.executeQuery();
    }
}