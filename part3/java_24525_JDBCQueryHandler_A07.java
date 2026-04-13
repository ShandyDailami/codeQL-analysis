import java.sql.*;

public class java_24525_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Query to select the user's role
            ResultSet resultSet = statement.executeQuery("SELECT role FROM users WHERE username = 'username'");

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                System.out.println("User role: " + role);
            } else {
                System.out.println("No user found with the given username.");
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}