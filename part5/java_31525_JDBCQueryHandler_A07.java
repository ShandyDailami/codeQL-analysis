import java.sql.*;

public class java_31525_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String USER = "root"; // change accordingly
    private static final String PASSWORD = "password"; // change accordingly
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase"; // change accordingly

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Define a query
            String query = "SELECT * FROM Users WHERE username = ?";

            // Step 3: Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 4: Set the parameter value
            preparedStatement.setString(1, "testUser"); // change accordingly

            // Step 5: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                System.out.println("User found");
            }

            // Step 7: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}