import java.sql.*;

public class java_13235_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_13235_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a connection to the database: " + e.getMessage());
        }
        return connection;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
        return resultSet;
    }

    public void executeUpdate(String update) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + e.getMessage());
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}