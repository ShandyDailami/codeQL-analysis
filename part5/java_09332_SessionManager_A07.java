import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_09332_SessionManager_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Step 4: Start a transaction
            connection.setAutoCommit(false);

            // Step 5: Execute a statement
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");
            preparedStatement.executeUpdate();

            // Step 6: Commit the transaction
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the statement and connection
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
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