import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14523_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Set parameters
            statement.setInt(1, 100);

            // Step 5: Execute the query
            statement.executeUpdate();

            // Step 6: Handle the result
            // ...

            // Step 7: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}