import java.sql.*;

public class java_39098_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_39098_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
       
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }
}