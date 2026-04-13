import java.sql.*;

public class java_26111_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;

    public java_26111_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
}