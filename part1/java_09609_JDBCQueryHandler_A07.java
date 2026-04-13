import java.sql.*;

public class java_09609_JDBCQueryHandler_A07 {
    private static String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static String username = "username";
    private static String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a Query
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            // Step 4: Clean Up
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}