import java.sql.*;
import java.util.*;

public class java_12412_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_12412_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public List<Map<String, Object>> executeQuery(String query, Object[] params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> results = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = meta.getColumnName(i);
                Object value = rs.getObject(i);
                row.put(columnName, value);
            }
            results.add(row);
        }

        rs.close();
        stmt.close();

        return results;
    }

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        String query = "SELECT * FROM users WHERE name=?";
        String[] params = {"John"};

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        List<Map<String, Object>> results = handler.executeQuery(query, params);

        for (Map<String, Object> row : results) {
            System.out.println(row);
        }
    }
}