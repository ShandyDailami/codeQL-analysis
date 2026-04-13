import java.sql.*;
import java.util.Properties;

public class java_00068_JDBCQueryHandler_A07 {
    private static Connection connection;

    // Method to establish a connection with the database
    public static Connection connect(String url, String user, String password) {
        Properties props = new Properties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "UTF-8");
            connection = DriverManager.getConnection(url, props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to execute a query
    public static ResultSet executeQuery(String query) {
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

    // Method to close the connection
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "username";
        String password = "password";

        connection = connect(url, user, password);

        // Insert a new user
        String insertUserQuery = "INSERT INTO users (username, password) VALUES ('newUser', 'newPassword')";
        executeQuery(insertUserQuery);

        // Fetch the user
        String fetchUserQuery = "SELECT * FROM users WHERE username = 'newUser'";
        ResultSet resultSet = executeQuery(fetchUserQuery);
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        closeConnection();
    }
}