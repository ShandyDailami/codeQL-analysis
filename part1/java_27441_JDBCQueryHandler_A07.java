import java.sql.*;

public class java_27441_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_27441_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            handleSQLException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // ignore close exception
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // ignore close exception
                }
            }
        }
        return resultSet;
    }

    private void handleSQLException(SQLException e) {
        // handle SQLException as needed
        // for now, print the exception stack trace
        e.printStackTrace();
    }
}