import java.sql.*;

public class java_25779_JDBCQueryHandler_A08 {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public java_25779_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } else {
                throw new RuntimeException("Connection is not established");
            }
        } catch (SQLException e) {
            System.out.println("Query execution failed");
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String update) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(update);
            } else {
                throw new RuntimeException("Connection is not established");
            }
        } catch (SQLException e) {
            System.out.println("Update execution failed");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection closed failed");
            e.printStackTrace();
        }
    }
}