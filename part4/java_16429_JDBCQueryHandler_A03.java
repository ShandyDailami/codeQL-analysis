import java.sql.*;

public class java_16429_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_16429_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}