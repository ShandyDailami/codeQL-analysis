import java.sql.*;

public class java_08956_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the SQL statement
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Step 3: Set the parameters
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");

            // Step 4: Execute the SQL statement
            preparedStatement.executeUpdate();

            System.out.println("Insertion successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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