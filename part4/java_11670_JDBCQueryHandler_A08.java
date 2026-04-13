import java.sql.*;
import java.util.Properties;

public class java_11670_JDBCQueryHandler_A08 {

    // Step 1: Define the connection URL, username, and password
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 2: Establish the connection
            Connection connection = getConnection();

            // Step 3: Perform a security-sensitive operation (get user's password hash)
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "user1"); // replace "user1" with the actual username

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String passwordHash = resultSet.getString("password");
                System.out.println("Password Hash: " + passwordHash);
            } else {
                System.out.println("No user found with the given username.");
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}