import java.sql.*;

public class java_30756_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'admin' AND password = 'password'");

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}