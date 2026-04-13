import java.sql.*;

public class java_09459_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            // Step 3: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // Do something with the username and password
            }

            // Step 4: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}