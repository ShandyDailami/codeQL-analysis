import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_26024_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Create a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Open a session
            connection.setAutoCommit(false);

            // 3. Prepare a statement
            statement = connection.prepareStatement("INSERT INTO SessionData (value) VALUES (?)");

            // 4. Set the value
            statement.setString(1, "Hello, World!");

            // 5. Execute the statement
            statement.executeUpdate();

            // 6. Close the statement
            statement.close();

            // 7. Commit the session
            connection.commit();

            // 8. Retrieve the value
            statement = connection.prepareStatement("SELECT value FROM SessionData WHERE id = (SELECT id FROM SessionData ORDER BY id DESC LIMIT 1)");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Retrieved value: " + resultSet.getString(1));
            }

            // 9. Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 10. Clean up
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}