import java.sql.*;

public class java_14251_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            preparedStatement.setString(1, "user1");

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("username"));
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}