import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_32199_JDBCQueryHandler_A01 {

    // Using an in-memory database for simplicity
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("User1", "password1"));
        users.add(new User("User2", "password2"));
    }

    public static void main(String[] args) {
        try {
            queryUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void queryUsers() throws SQLException {
        // Database connection
        Connection connection = DriverManager.getConnection("jdbc:mem:test", "username", "password");

        // Prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
        preparedStatement.setString(1, "User1");

        // Executing the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Extracting data from the result set
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }

        // Closing the connection
        connection.close();
    }

    static class User {
        private String username;
        private String password;

        public java_32199_JDBCQueryHandler_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters and setters here...
    }
}