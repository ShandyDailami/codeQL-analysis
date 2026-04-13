import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22334_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db"; // Path to your SQLite database file
        String selectQuery = "SELECT * FROM myTable"; // Your select query

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Set up connection
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            // Step 2: Execute query
            resultSet = statement.executeQuery(selectQuery);

            // Step 3: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("myColumn")); // Adjust this to your actual column names
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
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
                e.printStackTrace();
            }
        }
    }
}