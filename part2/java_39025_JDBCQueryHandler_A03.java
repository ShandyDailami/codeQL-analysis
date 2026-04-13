import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_39025_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare the SQL query
            String sql = "UPDATE users SET password = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set parameters and execute the query
            preparedStatement.setString(1, "newPassword"); // Password to set
            preparedStatement.setInt(2, 1); // User ID to set
            preparedStatement.executeUpdate();

            // Step 5: Close the resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}