import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19052_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }

        // Step 2: Connect to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }

        // Step 3: Execute the query
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable WHERE condition");

                // Step 4: Print the results
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("--------------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error executing query.");
                e.printStackTrace();
            }
        }

        // Step 5: Close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection.");
                e.printStackTrace();
            }
        }
    }
}