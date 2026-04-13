import java.sql.*;

public class java_39822_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established");

            // Step 2: Prepare the Statement
            Statement statement = connection.createStatement();
            System.out.println("Statement prepared");

            // Step 3: Execute the Query
            String query = "SELECT * FROM Users WHERE role = 'admin'";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Query executed");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}