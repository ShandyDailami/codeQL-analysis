import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05034_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get a connection from the connection pool
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare the SQL statement
            statement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");

            // Step 4: Execute the SQL statement
            statement.setInt(1, 123); // Assuming id is 123

            resultSet = statement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
}