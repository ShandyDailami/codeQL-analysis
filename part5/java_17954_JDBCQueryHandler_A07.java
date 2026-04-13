import java.sql.*;

public class java_17954_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username = 'test'");

            if (resultSet.next()) {
                String password = resultSet.getString(1);
                System.out.println("Password: " + password);
            } else {
                System.out.println("No password found for user 'test'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the resources
            try {
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