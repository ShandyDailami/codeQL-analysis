import java.sql.*;

public class java_06137_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_06137_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
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

    public void executeUpdate(String update) throws SQLException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}