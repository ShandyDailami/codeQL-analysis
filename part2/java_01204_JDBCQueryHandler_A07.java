import java.sql.*;

public class java_01204_JDBCQueryHandler_A07 {
    private static Connection connection;

    public static void connectDatabase(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean executeUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(update);
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // Connect to the database
        connectDatabase("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Execute a query
        ResultSet resultSet = executeQuery("SELECT * FROM Users");

        // Handle the result set
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }

        // Close the connection
        closeConnection();
    }
}