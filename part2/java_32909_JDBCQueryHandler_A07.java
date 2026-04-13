import java.sql.*;

public class java_32909_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Start a transaction
            connection.setAutoCommit(false);

            // Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username='" + args[0] + "' AND password='" + args[1] + "'");

            // Check if there is a result
            if (resultSet.next()) {
                System.out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}