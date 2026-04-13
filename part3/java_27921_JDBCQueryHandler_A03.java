import java.sql.*;

public class java_27921_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_27921_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void execute(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            // handle the result set
        }

        rs.close();
        stmt.close();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}