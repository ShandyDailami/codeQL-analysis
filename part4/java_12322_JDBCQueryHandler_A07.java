import java.sql.*;

public class java_12322_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_12322_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}