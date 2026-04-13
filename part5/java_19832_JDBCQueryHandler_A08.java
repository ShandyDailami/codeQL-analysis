import java.sql.*;

public class java_19832_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String sql = "SELECT * FROM users WHERE role = 'user'";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username + ", Role: " + role);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}