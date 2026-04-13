import java.sql.*;

public class java_11828_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Insert a new user
            String insertUser = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            statement.executeUpdate(insertUser);

            // Fetch the user
            String fetchUser = "SELECT * FROM users WHERE username = 'user1'";
            ResultSet resultSet = statement.executeQuery(fetchUser);
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Update the user
            String updateUser = "UPDATE users SET password = 'newpassword' WHERE username = 'user1'";
            statement.executeUpdate(updateUser);

            // Delete the user
            String deleteUser = "DELETE FROM users WHERE username = 'user1'";
            statement.executeUpdate(deleteUser);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}