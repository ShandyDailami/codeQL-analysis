import java.sql.*;

public class java_30312_JDBCQueryHandler_A01 {

    // The URL, username, and password for the database.
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        // Open a connection to the database.
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Prepare the SQL query.
            String query = "SELECT * FROM mytable";
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query.
            ResultSet result = statement.executeQuery();

            // Process the results.
            while (result.next()) {
                System.out.println(result.getString("myColumn"));
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}