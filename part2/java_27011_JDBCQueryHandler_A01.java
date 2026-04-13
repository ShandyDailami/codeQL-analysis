import java.sql.*;

public class java_27011_JDBCQueryHandler_A01 {
    private Connection connection;
    private PreparedStatement statement;

    public java_27011_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query, Object... params) throws SQLException {
        statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.println(result.getString("name"));
        }

        statement.close();
        connection.close();
    }
}