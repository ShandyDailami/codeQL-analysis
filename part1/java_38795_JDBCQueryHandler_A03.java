import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_38795_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void executeQuery(String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the SQL query
            preparedStatement = connection.prepareStatement(query);

            // Step 3: Execute the SQL query
            preparedStatement.executeUpdate();

            // Step 4: Clean up
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}