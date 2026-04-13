import java.sql.*;

public class java_31017_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create Connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create Statement
            statement = connection.createStatement();

            // Step 4: Execute Query
            String query = "SELECT * FROM users WHERE role='ADMIN' AND status='ACTIVE'";
            resultSet = statement.executeQuery(query);

            // Step 5: Process Result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultResult.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close Connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Cleanup
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
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