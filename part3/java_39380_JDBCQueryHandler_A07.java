import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39380_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            statement = connection.createStatement();

            // Step 4: Execute the query
            resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 5: Process the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of use
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* intentionally left blank */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* intentionally left blank */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* intentionally left blank */ }
        }
    }
}