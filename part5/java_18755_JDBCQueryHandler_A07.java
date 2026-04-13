import java.sql.*;

public class java_18755_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_18755_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public PreparedStatement createPreparedStatement(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn.prepareStatement(query);
    }
}