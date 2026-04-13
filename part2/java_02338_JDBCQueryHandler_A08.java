import java.sql.*;

public class java_02338_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish the database connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare the statement
            statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Step 4: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}