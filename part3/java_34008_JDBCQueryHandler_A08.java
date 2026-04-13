import java.sql.*;

public class java_34008_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE password = 'password'");

            // Step 4: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in JDBCQueryHandler: " + e.getMessage());
        }
    }
}