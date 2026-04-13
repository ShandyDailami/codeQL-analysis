import java.sql.*;

public class java_32626_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Found user: " + resultSet.getString("username"));
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}