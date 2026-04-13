import java.sql.*;

public class java_13143_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish the connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL statement
            String sql = "SELECT * FROM Users WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 3: Set the parameter
            preparedStatement.setString(1, "testUser");

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Cleanup
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}