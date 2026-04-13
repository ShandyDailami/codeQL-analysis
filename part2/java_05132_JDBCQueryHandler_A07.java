import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05132_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public boolean checkAuthFailure(String userId) {
        String query = "SELECT * FROM Users WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the statement
            statement = connection.prepareStatement(query);

            // Set the parameter
            statement.setString(1, userId);

            // Execute the statement
            resultSet = statement.executeQuery();

            // If the user exists in the database, return true
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (resultSet != null) try { resultSet.close(); } catch(SQLException se) { /* can't do anything */ }
            if (statement != null) try { statement.close(); } catch(SQLException se) { /* can't do anything */ }
            if (connection != null) try { connection.close(); } catch(SQLException se) { /* can't do anything */ }
        }

        return false;
    }
}