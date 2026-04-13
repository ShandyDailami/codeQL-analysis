import java.sql.*;

public class java_38854_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";

        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseName", "username", "password");

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set the parameters
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Step 5: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            // Step 6: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}