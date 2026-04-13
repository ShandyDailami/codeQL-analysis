import java.sql.*;

public class java_41456_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register the JDBC driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 3: Prepare the statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute the query
            preparedStatement.setString(1, "testUser"); // Replace with actual user input
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}