import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12414_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM mytable WHERE mycolumn = 'myvalue'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                // Process the data
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle any errors
            e.printStackTrace();
        } finally {
            // Step 6: Close the ResultSet, Statement, and Connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}