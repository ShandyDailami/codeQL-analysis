import java.sql.*;

public class java_28468_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // 2. Prepare the SQL statement
            String query = "UPDATE users SET username = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);

            // 3. Set parameters and execute the query
            preparedStatement.setString(1, "newUsername");
            preparedStatement.setInt(2, 1000);
            preparedStatement.executeUpdate();

            System.out.println("Record updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. Clean up the resources
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}