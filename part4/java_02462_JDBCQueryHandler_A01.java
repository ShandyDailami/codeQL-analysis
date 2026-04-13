import java.sql.*;

public class java_02462_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_02462_JDBCQueryHandler_A01(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.executeUpdate();
    }

    public void close() throws SQLException {
        conn.close();
    }
}