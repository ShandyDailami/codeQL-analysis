import java.sql.*;

public class java_00411_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            String query = "SELECT * FROM Users WHERE Email = 'user@example.com' AND Password = 'password'";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                System.out.println("Email: " + email + ", Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}