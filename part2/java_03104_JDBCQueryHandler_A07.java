import java.sql.*;

public class java_03104_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Start the database transaction
            connection.setAutoCommit(false);

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'admin' AND password = 'password'");

            if (resultSet.next()) {
                // If the user exists, authenticate them
                System.out.println("User authenticated successfully!");
            } else {
                // If the user does not exist, fail the authentication
                System.out.println("Authentication failed!");
            }

            // Close the connection and the statement
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}