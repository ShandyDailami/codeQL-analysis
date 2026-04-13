import java.sql.*;

public class java_16780_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_16780_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
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
        conn.close();
    }

}