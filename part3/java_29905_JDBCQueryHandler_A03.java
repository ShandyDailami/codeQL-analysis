import java.sql.*;

public class java_29905_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_29905_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return resultSet;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
           
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}