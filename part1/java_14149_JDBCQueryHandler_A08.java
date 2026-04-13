import java.sql.*;

public class java_14149_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE id = ?");

            // Step 3: Set the parameters
            statement.setInt(1, 123); // For example, let's say the id is 123

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                System.out.println("User ID: " + result.getInt("id"));
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}