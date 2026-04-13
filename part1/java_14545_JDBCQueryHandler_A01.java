import java.sql.*;

public class java_14545_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'myuser' AND password = 'mypassword'");

            // Step 4: Process the result
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}