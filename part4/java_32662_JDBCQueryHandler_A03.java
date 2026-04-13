import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_32662_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the database connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL statement
            String query = "SELECT * FROM mytable WHERE id = ?";
            statement = connection.prepareStatement(query);

            // Step 4: Set the parameter
            statement.setInt(1, 1001);

            // Step 5: Execute the statement
            ResultSet result = statement.executeQuery();

            // Step 6: Process the result
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Clean up
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) { /* ignored */ }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { /* ignored */ }
            }
        }
    }
}