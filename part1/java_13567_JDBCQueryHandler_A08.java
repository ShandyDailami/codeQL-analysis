import java.sql.*;

public class java_13567_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            statement = connection.createStatement();

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM my_table WHERE id = 'a08' AND password = '1234'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the result
            while (resultSet.next()) {
                // Here, we assume that the integrity failure happens when the password is incorrect
                if (!resultSet.getString("password").equals("1234")) {
                    System.out.println("Integrity failure detected!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection and statement
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