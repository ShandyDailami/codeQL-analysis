import java.sql.*;

public class java_40917_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_40917_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query, String... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }

    public void executeUpdate(String query, String... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1, params[i]);
        }
        stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}