import java.sql.*;

public class java_04618_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare statement
            String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            Statement statement = connection.createStatement();

            // Step 3: Execute query and process result
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            // Step 4: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}