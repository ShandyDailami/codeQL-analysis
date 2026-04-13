import java.sql.*;

public class java_23435_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create statement
            Statement statement = connection.createStatement();

            // Define SQL query
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

            // Prepare statement for execution
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");

            // Execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                System.out.println("User found!");
            }

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}