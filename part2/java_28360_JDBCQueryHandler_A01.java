import java.sql.*;

public class java_28360_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email='test@test.com'");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}