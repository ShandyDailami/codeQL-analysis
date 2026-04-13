import java.sql.*;

public class java_03319_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // 1. Open a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Run a SQL query to select the user's password
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username = 'testuser'");

            // 3. Check if the input password matches the stored password
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (storedPassword.equals("password")) {
                    System.out.println("Password matches!");
                } else {
                    System.out.println("Password does not match.");
                }
            } else {
                System.out.println("No user found with the given username.");
            }

            // 4. Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}