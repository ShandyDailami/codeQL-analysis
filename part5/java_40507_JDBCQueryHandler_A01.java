import java.sql.*;

public class java_40507_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            statement = connection.createStatement();

            // Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 4: Process the Results
            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the Connection
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