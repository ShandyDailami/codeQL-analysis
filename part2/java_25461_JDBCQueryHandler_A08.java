import java.sql.*;

public class java_25461_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameters and execute the query
            preparedStatement.setString(1, "John");
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                // Process name...
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