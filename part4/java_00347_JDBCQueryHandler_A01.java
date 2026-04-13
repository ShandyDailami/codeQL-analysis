import java.sql.*;
import java.util.Properties;

public class java_00347_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_00347_JDBCQueryHandler_A01() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        Properties props = new Properties();
        props.setProperty("user", "user");
        props.setProperty("password", "password");
        props.setProperty("useSSL", "false");
        props.setProperty("serverSelection", "DRIVER");

        try {
            connection = DriverManager.getConnection("jdbc:databaseURL", props);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public int executeUpdate(String query) {
        int result = 0;

        try {
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example of accessing data
        String query = "SELECT * FROM users";
        ResultSet resultSet = handler.executeQuery(query);

        // Access data
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        handler.closeConnection();
    }
}