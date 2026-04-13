import java.sql.*;

public class java_36682_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement for the query
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter value and execute the query
            preparedStatement.setInt(1, 123); // Replace 123 with the actual id
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Handle the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                // Do something with the user name
            }

            // Step 5: Clean up the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}