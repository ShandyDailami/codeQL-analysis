import java.sql.*;

public class java_20239_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'user' AND password = 'pass'");

            // Step 4: Handle Result
            while (resultSet.next()) {
                System.out.println("User Found!");
            }

            // Step 5: Close Connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}