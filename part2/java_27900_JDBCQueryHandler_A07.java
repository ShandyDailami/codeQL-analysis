import java.sql.*;

public class java_27900_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 3: Set parameters
            String username = "user1";
            String password = "password1";
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                System.out.println("User: " + user + ", Password: " + pass);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}