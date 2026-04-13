import java.sql.*;

public class java_14533_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 3: Set parameters
            statement.setInt(1, 123); // replace with the actual id

            // Step 4: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Step 5: Process the results
                String name = resultSet.getString("name");
                // ...
            }

            // Step 6: Cleanup
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}