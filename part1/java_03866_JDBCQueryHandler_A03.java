import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03866_JDBCQueryHandler_A03 {

    // Hard-coded database credentials, not recommended for production code
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, "admin"); // This is a security-sensitive operation related to injection

            // Step 4: Execute the statement
            resultSet = statement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                // Do something with the username
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}