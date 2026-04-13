import java.sql.*;

public class java_24084_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare Statements
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");

            // Step 3: Set Parameters
            preparedStatement.setString(1, "user@example.com"); // Replace with actual user email

            // Step 4: Execute Query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process Result
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Step 6: Close Connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}