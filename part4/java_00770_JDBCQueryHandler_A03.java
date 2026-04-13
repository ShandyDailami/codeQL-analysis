import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00770_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public void runQuery(String query) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a prepared statement
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Execute the query
            resultSet = preparedStatement.executeQuery();

            // Step 5: Process the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } finally {
            // Step 6: Clean up
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}