import java.sql.*;

public class java_39735_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT * FROM auth_failures"; // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // process the result set here, e.g., print out the failure details
                System.out.println("Failure ID: " + resultSet.getInt("id"));
                System.out.println("Failure Time: " + resultSet.getTimestamp("failure_time"));
                // ...
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }
}