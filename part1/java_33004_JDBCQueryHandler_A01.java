import java.sql.*;

public class java_33004_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Establish the Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            statement = connection.createStatement();

            // Step 4: Execute a SQL Query
            resultSet = statement.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}