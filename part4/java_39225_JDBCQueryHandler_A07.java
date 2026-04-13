import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39225_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            statement = connection.createStatement();

            // 4. Execute a SQL query
            resultSet = statement.executeQuery("SELECT * FROM Users WHERE AuthFailure > 5");

            // 5. Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                int authFailureCount = resultSet.getInt("AuthFailure");
                System.out.println("Username: " + username + ", AuthFailure Count: " + authFailureCount);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}