import java.sql.*;

public class java_05208_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_05208_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public <T> List<T> fetchList(String query, ResultSetExtractor<T> extractor, Object... parameters) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(query);
        for (int i = 0; i < parameters.length; i++) {
            pstmt.setObject(i + 1, parameters[i]);
        }
        return pstmt.executeQuery().getResultList();
    }

    public <T> T fetchSingleValue(String query, Object... parameters) throws SQLException {
        List<T> list = fetchList(query, rs -> {
            if (rs.next()) {
                return (T) rs.getObject(1);
            }
            return null;
        }, parameters);
        return list.isEmpty() ? null : list.get(0);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}