import java.sql.*;

public class java_26509_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish the Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the Statement
            statement = connection.createStatement();

            // Step 3: Execute the Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE role='admin'");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Clean up the Connection and Statement
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}