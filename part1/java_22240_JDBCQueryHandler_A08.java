import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_22240_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_22240_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
        this.stmt = conn.createStatement();
    }

    public List<String> executeQuery(String query) throws SQLException {
        ResultSet rs = stmt.executeQuery(query);

        List<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(1));
        }

        return result;
    }

    public void executeUpdate(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        stmt.close();
        conn.close();
    }
}