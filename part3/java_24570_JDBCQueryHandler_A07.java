import java.sql.*;

public class java_24570_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_24570_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        connection.close();

        return resultSet;
    }
}