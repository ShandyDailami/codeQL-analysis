import java.sql.*;

public class java_00935_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String USER = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + USER + "' AND password = '" + PASSWORD + "'");

            // Process the result
            while (resultSet.next()) {
                System.out.println("User found");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}