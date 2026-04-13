import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_08954_JDBCQueryHandler_A01 {
    // private fields
    private String url;
    private String username;
    private String password;

    // constructor
    public java_08954_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method to connect to the database
    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }

    // method to execute a query and return the ResultSet
    public ResultSet executeQuery(String query) {
        Connection connection = connect();
        Statement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        }
        return resultSet;
    }

    // method to close the connection
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // method to execute a query with parameterized input
    public ResultSet executeQuery(String query, Object[] parameters) {
        Connection connection = connect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(query);
                for (int i = 0; i < parameters.length; i++) {
                    statement.setObject(i + 1, parameters[i]);
                }
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        }
        return resultSet;
    }
}