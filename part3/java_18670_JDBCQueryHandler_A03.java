import java.sql.*;

public class java_18670_JDBCQueryHandler_A03 {

    // private fields
    private String url;
    private String username;
    private String password;

    // constructor
    public java_18670_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to handle a query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // get a connection
            connection = DriverManager.getConnection(url, username, password);
            // create a statement object
            Statement statement = connection.createStatement();
            // execute the query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
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

    // method to handle a statement
    public void executeUpdate(String query) throws SQLException {
        Connection connection = null;
        try {
            // get a connection
            connection = DriverManager.getConnection(url, username, password);
            // create a statement object
            Statement statement = connection.createStatement();
            // execute the query
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}