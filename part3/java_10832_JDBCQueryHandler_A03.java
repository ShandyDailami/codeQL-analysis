import java.sql.*;

public class java_10832_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 4: Process the Result Set
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}