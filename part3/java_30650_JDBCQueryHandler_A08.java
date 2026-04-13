import java.sql.*;

public class java_30650_JDBCQueryHandler_A08 {

    // The database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Prepare the statement
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1, "testuser");

            // Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (verifyPassword(storedPassword, "testpassword")) {
                    System.out.println("Password is correct.");
                } else {
                    System.out.println("Password is incorrect.");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statements and connections
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean verifyPassword(String storedPassword, String inputPassword) {
        // For simplicity, we'll just return whether the input password matches the stored password.
        // This is a very weak way to handle passwords, and a real-world application would need
        // a more secure method of handling passwords.
        return inputPassword.equals(storedPassword);
    }
}