import java.sql.*;

public class java_20871_JDBCQueryHandler_A01 {

    // Method to connect to database
    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to execute a query
    public ResultSet executeQuery(Connection connection, String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to close connections
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection connection = handler.connectToDatabase("jdbc:mysql://localhost/test", "username", "password");
        ResultSet resultSet = handler.executeQuery(connection, "SELECT * FROM users");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Name: " + name);
        }
        handler.closeConnection(connection);
    }
}