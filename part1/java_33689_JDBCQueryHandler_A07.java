import java.sql.*;

public class java_33689_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_33689_JDBCQueryHandler_A07(String dbURL, String dbUser, String dbPass) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}