import java.sql.*;

public class java_37350_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_37350_JDBCQueryHandler_A01(String dbUrl, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, user, password);
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