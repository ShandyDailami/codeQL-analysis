import java.sql.*;

public class java_25170_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM users WHERE username = '" + args[0] + "'";
            resultSet = statement.executeQuery(query);

            // Step 4: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Cleanup (Always close resources)
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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