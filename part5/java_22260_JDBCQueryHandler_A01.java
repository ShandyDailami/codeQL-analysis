import java.sql.*;

public class java_22260_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String updatePasswordQuery = "UPDATE user_info SET password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(updatePasswordQuery);

            // Step 3: Set parameters and execute the query
            statement.setString(1, "new_password"); // new password
            statement.setInt(2, 1); // user id
            statement.executeUpdate();

            // Step 4: Close the connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
        }
    }
}