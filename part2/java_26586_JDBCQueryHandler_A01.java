import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_26586_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_26586_JDBCQueryHandler_A01(String dbUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public List<String> fetchData(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(1)); // Assuming the query returns a single string
        }
        return result;
    }

    public void updateData(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}