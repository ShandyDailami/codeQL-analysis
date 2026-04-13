import java.sql.*;
import java.util.concurrent.Callable;

public class java_26602_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_26602_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public <T> T executeQuery(Callable<T> query, ResultHandler<T> resultHandler) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query.call());
        return resultHandler.handle(rs);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}