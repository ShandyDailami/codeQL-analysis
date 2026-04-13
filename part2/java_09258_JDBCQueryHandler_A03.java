import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09258_JDBCQueryHandler_A03 {

    public void executeQuery(String url, String username, String password, String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Establish the Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the Statement
            statement = connection.createStatement();

            // Step 4: Execute the Query
            resultSet = statement.executeQuery(query);

            // Step 5: Process the Result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column1") + " " + resultSet.getString("column2"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
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