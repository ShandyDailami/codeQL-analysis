import java.sql.*;
import java.util.*;

public class java_08746_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_08746_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}