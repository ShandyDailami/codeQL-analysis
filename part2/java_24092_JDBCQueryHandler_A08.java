import java.sql.*;

public class java_24092_JDBCQueryHandler_A08 {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM test_table"; // replace with your query
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // process the data
            }

            // Step 5: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}