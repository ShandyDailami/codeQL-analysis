import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32305_SessionManager_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Start a transaction
            connection.setAutoCommit(false);

            // Create a new session
            String sessionData = "Test session data";
            String insertQuery = "INSERT INTO SESSION (session_data) VALUES ('" + sessionData + "')";
            statement.executeUpdate(insertQuery);

            // Commit the transaction
            connection.commit();

            // Retrieve the session's data
            String selectQuery = "SELECT session_data FROM SESSION WHERE session_data LIKE '%" + sessionData + "%'";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                System.out.println("Session data: " + resultSet.getString("session_data"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
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