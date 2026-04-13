import java.sql.*;

public class java_09142_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database");

            // Step 2: Run a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE role='Admin'");

            // Step 3: Handle security-sensitive operations related to A08_IntegrityFailure
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                // Here we can implement our security-sensitive operations, but this is out of the scope.
                System.out.println("Password: " + password);
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}