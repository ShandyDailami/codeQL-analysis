import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_36214_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // or use the correct driver for your database

            // Step 2: Establish database connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL query
            String query = "UPDATE your_table SET your_column = ? WHERE your_condition = ?";
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Execute SQL query
            preparedStatement.setString(1, "new value"); // new value to be updated
            preparedStatement.setString(2, "condition value"); // condition value
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close database resources
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