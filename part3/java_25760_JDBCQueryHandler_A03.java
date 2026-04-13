import java.sql.*;

public class java_25760_JDBCQueryHandler_A03 {

    // The URL of the database we want to connect to
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    // The username and password for the database
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            // Create a statement
            statement = connection.createStatement();
            // Execute a SQL query
            String sql = "SELECT * FROM my_table";
            resultSet = statement.executeQuery(sql);

            // Print out each row of the result set
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
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