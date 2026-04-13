import java.sql.*;

public class java_02565_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_02565_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}