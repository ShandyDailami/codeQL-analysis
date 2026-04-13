import java.sql.*;

public class java_15841_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}