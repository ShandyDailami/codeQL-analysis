import java.sql.*;

public class java_01571_JDBCQueryHandler_A08 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = getConnection();

            // Step 2: Execute a query
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM Users");

            // Step 3: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 4: Cleanup
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            // Step 1a: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1b: Establish the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Step 1c: Set the connection's autocommit mode to false
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}