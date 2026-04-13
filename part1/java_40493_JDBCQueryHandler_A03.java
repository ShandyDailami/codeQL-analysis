import java.sql.*;

public class java_40493_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;

    public java_40493_JDBCQueryHandler_A03(String dbUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, username, password);
        this.stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
}