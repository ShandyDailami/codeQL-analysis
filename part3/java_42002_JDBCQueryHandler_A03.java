import java.sql.*;

public class java_42002_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_42002_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query, Object[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        return stmt.executeQuery();
    }

    public void executeUpdate(String query, Object[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        stmt.executeUpdate();
    }
}