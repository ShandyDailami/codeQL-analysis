import java.sql.*;

public class java_13636_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Create a SQL query
            String query = "INSERT INTO myTable (name, age) VALUES (?, ?)";

            // Step 4: Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 5: Set parameters
            preparedStatement.setString(1, "John Doe");
            preparedStatement.setInt(2, 25);

            // Step 6: Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            // Step 7: Print the result
            System.out.println("Rows inserted: " + rowsInserted);

            // Step 8: Close the connection
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}