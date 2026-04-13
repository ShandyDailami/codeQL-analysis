import java.sql.*;

public class java_32484_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'ADMIN'");

            // 4. Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
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