import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_00869_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver

            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "username";
            String password = "password";

            // Open a connection to MySQL
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            String query = "SELECT * FROM mytable";
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query and print the results
            statement.executeQuery();

            // Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}