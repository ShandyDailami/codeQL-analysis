import java.sql.*;

public class java_02747_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            String query = "SELECT * FROM your_table WHERE your_column = ?";
            preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameters
            preparedStatement.setString(1, "your_value");

            // Step 4: Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Found user: " + resultSet.getString("your_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
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