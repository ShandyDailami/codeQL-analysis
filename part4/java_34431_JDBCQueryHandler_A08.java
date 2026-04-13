import java.sql.*;

public class java_34431_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_34431_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
        this.stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        stmt.close();
        conn.close();
    }
}