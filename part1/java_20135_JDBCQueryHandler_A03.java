import java.sql.*;

public class java_20135_JDBCQueryHandler_A03 {

    // The URL of your database.
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // The username and password for your database.
    private static final String USERNAME = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Step 5: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query: " + e.getMessage());
        }
    }
}