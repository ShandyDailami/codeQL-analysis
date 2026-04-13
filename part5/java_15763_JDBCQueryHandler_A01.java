import java.sql.*;

public class java_15763_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_15763_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}