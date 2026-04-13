import java.sql.*;

public class java_40847_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String user = "user";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register the driver
            DriverManager.registerDriver(new org.postgresql.Driver());

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("Failed to authenticate user!");
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}