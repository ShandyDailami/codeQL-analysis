import java.sql.*;

public class java_21841_JDBCQueryHandler_A08 {
    // Connection object
    private static Connection connection = null;

    // Main method
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Start the process
            startProcess();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to start the process
    private static void startProcess() {
        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameter value
            statement.setString(1, "testuser");

            // Execute the statement
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}