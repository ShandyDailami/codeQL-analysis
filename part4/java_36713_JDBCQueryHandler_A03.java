import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_36713_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_36713_JDBCQueryHandler_A03(String dbUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public List<String> executeQuery(String query) throws SQLException {
        List<String> result = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            result.add(rs.getString("column_name"));
        }

        return result;
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}