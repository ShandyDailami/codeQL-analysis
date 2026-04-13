import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16748_SessionManager_A08 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }

        // Step 2: Create a connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return;
        }

        // Step 3: Use the connection to perform operations
        // In this case, we are performing a simple integrity failure operation
        // This might involve something like creating a table and inserting data,
        // then trying to select all data from the table and print it out

        // Assume there's a table called "users" with a column "id" and "name"
        String selectSQL = "SELECT id, name FROM users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query.");
            e.printStackTrace();
        }

        // Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while closing connection.");
            e.printStackTrace();
        }
    }
}