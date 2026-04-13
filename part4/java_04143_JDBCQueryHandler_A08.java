import java.sql.*;

public class java_04143_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection successful!");

            // Step 2: Prepare the statement
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "value_to_match");

            // Step 4: Execute the statement
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                String columnValue = result.getString("my_column");
                System.out.println("Column value: " + columnValue);
            // TODO: Add your security-sensitive operations here
            }

            // Step 6: Close the connection
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
        }
    }
}