import java.sql.*;

public class java_32519_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String selectQuery = "SELECT * FROM table_name WHERE column_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "value");

            // Step 3: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("Found user with id: " + resultSet.getString("column_name"));
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
        }
    }
}