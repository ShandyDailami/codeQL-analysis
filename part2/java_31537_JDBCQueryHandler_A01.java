import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31537_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Step 3: Perform queries
            // For the sake of this example, let's assume we want to select all records from a table named 'Users'
            String selectQuery = "SELECT * FROM Users";

            // Step 4: Handle the result set
            // This is a simple example of reading data from a result set.
            // In a real-world application, you would likely use a Statement or PreparedStatement
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                }
            }

            // Step 5: Clean up
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}