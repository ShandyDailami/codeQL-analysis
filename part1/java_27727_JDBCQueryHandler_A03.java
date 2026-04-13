import java.sql.*;

public class java_27727_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_27727_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        return statement.executeQuery();
    }

    public void executeUpdate(String query, Object... params) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        statement.executeUpdate();
    }
}