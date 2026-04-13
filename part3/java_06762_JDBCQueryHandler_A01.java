import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06762_JDBCQueryHandler_A01 {
    // In a real-world scenario, this should not be hard-coded.
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myUser";
    private static final String PASSWORD = "myPassword";

    public static void main(String[] args) {
        // Step 1: Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 3: Execute a query
        String query = "SELECT * FROM myTable"; // This should not be hard-coded
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // Step 4: Handle the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                // Do something with the name
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}