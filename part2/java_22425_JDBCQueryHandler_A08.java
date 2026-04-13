import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22425_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 3: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("username: " + username);
                System.out.println("password: " + password);
            }

        } catch (SQLException e) {
            System.out.println("Error accessing the database");
            e.printStackTrace();

        } finally {
            // Step 4: Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing the database connection");
                e.printStackTrace();
            }
        }
    }
}