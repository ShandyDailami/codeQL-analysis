import java.sql.*;

public class java_28392_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 4: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignore */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* ignore */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignore */ }
        }
    }
}