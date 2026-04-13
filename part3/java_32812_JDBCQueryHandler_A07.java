import java.sql.*;

public class java_32812_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_32812_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultSet;
    }

    public int executeUpdate(String query) throws SQLException {
        Connection connection = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return result;
    }
}