import java.sql.*;

public class java_35949_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Establish a connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare the SQL query
            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Step 3: Set the parameters for the query
            statement.setString(1, "user1");
            statement.setString(2, "password1");
            statement.setString(3, "user1@example.com");

            // Step 4: Execute the query
            statement.executeUpdate();

            System.out.println("User added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection
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