import java.sql.*;

public class java_18909_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform SQL Query
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "user1"); // User input

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usernameColumn = resultSet.getString("username");
                String passwordColumn = resultSet.getString("password");

                System.out.println("Username: " + usernameColumn);
                System.out.println("Password: " + passwordColumn);
            }

            // Step 4: Clean Up
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}