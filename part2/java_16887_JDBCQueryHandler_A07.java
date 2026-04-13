import java.sql.*;

public class java_16887_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Step 2: Open Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'user' AND password = 'pass'");

            // Step 5: Process Result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 6: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}