import java.sql.*;

public class java_22980_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_22980_JDBCQueryHandler_A03(String dbUrl, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, username, password);
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
        conn.close();
    }
}