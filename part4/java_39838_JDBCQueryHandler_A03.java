import java.sql.*;

public class java_39838_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_39838_JDBCQueryHandler_A03(String dbURL, String userName, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public <T> List<T> getList(String query, RowMapper<T> mapper, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i, params[i]);
        }

        ResultSet rs = stmt.executeQuery();

        List<T> list = new ArrayList<>();
        while (rs.next()) {
            list.add(mapper.mapRow(rs));
        }

        return list;
    }

    public <T> T getSingleValue(String query, RowMapper<T> mapper, Object... params) throws SQLException {
        List<T> list = getList(query, mapper, params);
        return (list != null && !list.isEmpty()) ? list.get(0) : null;
    }

    public static interface RowMapper<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }
}