import java.sql.*;

public class java_42110_JDBCQueryHandler_A01 {

    // Define the database URL, user and password
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {

            // Create a statement object
            Statement statement = connection.createStatement();

            // Define the SQL query
            String query = "SELECT * FROM users WHERE username = 'test'";

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Print all the results
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}