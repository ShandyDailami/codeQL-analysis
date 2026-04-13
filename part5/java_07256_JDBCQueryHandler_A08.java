import java.sql.*;

public class java_07256_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM users WHERE age = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter
            preparedStatement.setInt(1, 30);

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            // Step 6: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while executing query: " + e.getMessage());
        }
    }
}