import java.sql.*;

public class java_40013_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement object
            statement = connection.createStatement();

            // 3. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'invalid_user'");

            // 4. Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // 5. Authentication failure code here
                // ...
            }

            // 6. Close the statement and connection
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}