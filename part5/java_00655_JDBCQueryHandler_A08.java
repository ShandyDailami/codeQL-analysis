import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00655_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare the SQL statement
            statement = connection.prepareStatement("SELECT * FROM my_table WHERE id = ?");
            statement.setInt(1, 123); // You would replace this with your actual id

            // Step 4: Execute the SQL statement
            resultSet = statement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
}