import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_26211_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement with ? placeholders
            String sql = "SELECT * FROM employees WHERE name = ?";
            statement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute query
            statement.setString(1, "John Doe");

            // Step 5: Process the results
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println("Name: " + result.getString("name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up: close the ResultSet and Statement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}