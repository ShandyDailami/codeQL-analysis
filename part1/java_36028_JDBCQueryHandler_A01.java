import java.sql.*;

public class java_36028_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_36028_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}