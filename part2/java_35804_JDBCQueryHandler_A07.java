import java.sql.*;

public class java_35804_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement for executing a simple query
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            String sql = "SELECT * FROM Users WHERE username = 'alice' AND password = 'secret'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Cleanup
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}