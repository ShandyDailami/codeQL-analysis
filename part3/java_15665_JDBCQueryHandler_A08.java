import java.sql.*;

public class java_15665_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish the Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the Statement
            statement = connection.createStatement();

            // Step 3: Execute the Query
            String sql = "SELECT * FROM Users WHERE role='admin'";
            resultSet = statement.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getString("userId"));
                System.out.println("User Name: " + resultSet.getString("userName"));
                System.out.println("User Role: " + resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the Connection and Statement
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}