import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28527_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create Statement
            statement = connection.createStatement();

            // Step 4: Execute Query
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            resultSet = statement.executeQuery(sql, "user1", "password1");

            // Step 5: Process Result
            while (resultSet.next()) {
                System.out.println("User Found!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Connection, Statement and ResultSet
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