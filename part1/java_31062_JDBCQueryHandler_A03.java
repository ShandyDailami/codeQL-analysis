import java.sql.*;

public class java_31062_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Establish a connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 2. Prepare the SQL statement
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, "john_doe"); // A security-sensitive operation related to A03_Injection

            // 3. Execute the statement and process the result set
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. Close resources in a finally block
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