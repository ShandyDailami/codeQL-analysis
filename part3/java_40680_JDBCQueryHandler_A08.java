import java.sql.*;

public class java_40680_JDBCQueryHandler_A08 {

    // Define database parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    private static Connection connection;

    // Define the SQL query
    private static final String SQL_QUERY = "SELECT * FROM Users WHERE username = ?";

    // Execute the query method
    public static ResultSet executeQuery(String username) {
        try {
            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

            // Set the parameter
            preparedStatement.setString(1, username);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ResultSet resultSet = executeQuery("myuser");
        try {
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}