import java.sql.*;

public class java_01494_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "testUser");

            // Step 3: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }

            // Step 5: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}