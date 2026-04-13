import java.sql.*;

public class java_01443_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameters
            preparedStatement.setString(1, "testUser");

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Handle the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}