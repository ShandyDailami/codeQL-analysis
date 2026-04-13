import java.sql.*;

public class java_35117_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
            connection.setAutoCommit(false);

            // Step 2: Prepare a Statement
            statement = connection.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            // Step 3: Execute the Statement
            statement.executeUpdate();

            // Step 4: Commit the Transaction
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the Statement and Connection
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