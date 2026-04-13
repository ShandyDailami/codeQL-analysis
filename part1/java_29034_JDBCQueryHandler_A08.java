import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_29034_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String username = "yourUsername";
    private static final String password = "yourPassword";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare SQL statement
            String query = "SELECT * FROM yourTable";
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Execute SQL statement
            resultSet = preparedStatement.executeQuery();

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // ... process the data
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignored */ }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { /* ignored */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
}