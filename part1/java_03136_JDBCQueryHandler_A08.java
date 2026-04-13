import java.sql.*;

public class java_03136_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}