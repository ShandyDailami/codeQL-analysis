import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17800_JDBCQueryHandler_A03 {

    // private fields for database configuration
    private String url;
    private String username;
    private String password;

    // constructor to initialize the connection
    public java_17800_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to execute a query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // create a connection
            connection = DriverManager.getConnection(url, username, password);

            // prepare the query
            statement = connection.prepareStatement(query);

            // execute the query
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the resources
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return resultSet;
    }
}