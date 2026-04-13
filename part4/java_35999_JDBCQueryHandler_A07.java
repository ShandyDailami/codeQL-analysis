import java.sql.*;

public class java_35999_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter and execute the statement
            preparedStatement.setString(1, "user1"); // replace 'user1' with the actual username
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Handle the result
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}