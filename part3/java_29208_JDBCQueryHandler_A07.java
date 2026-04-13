import java.sql.*;

public class java_29208_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM Users WHERE username = 'baduser' AND password = 'badpassword'";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Handle the result set
            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
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