import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24169_JDBCQueryHandler_A08 {

    // This is a placeholder for your actual database details.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        System.out.println("Connecting to database...");
        Connection connection = connectToDatabase();
        if (connection != null) {
            System.out.println("Connected successfully!");
            String username = "example";  // Replace with the actual username.
            User user = findUser(connection, username);
            if (user != null) {
                System.out.println("User found: " + user.getName());
            } else {
                System.out.println("User not found.");
            }
            closeConnection(connection);
        }
    }

    private static Connection connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            return null;
        }
    }

    private static User findUser(Connection connection, String username) {
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM users WHERE username = ?";
                ResultSet rs = stmt.executeQuery(sql, username);
                if (rs.next()) {
                    return new User(rs.getString("username"), rs.getString("password"));
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving user from database.");
            }
        }
        return null;
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection.");
            }
        }
    }

    static class User {
        private String username;
        private String password;

        public java_24169_JDBCQueryHandler_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}