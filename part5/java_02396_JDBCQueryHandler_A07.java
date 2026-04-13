import java.sql.*;

public class java_02396_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // 1. Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. Prepare a statement
            Statement statement = connection.createStatement();

            // 3. Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // 4. Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Authenticated user: " + username);
            }

            // 5. Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}