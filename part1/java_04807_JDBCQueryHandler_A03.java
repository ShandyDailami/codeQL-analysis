import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_04807_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare Statement
            statement = connection.createStatement();

            // Step 4: Execute Query
            String sql = "SELECT * FROM Users"; // your SQL query
            resultSet = statement.executeQuery(sql);

            // Step 5: Process Result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Resources
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