import java.sql.*;

public class java_27863_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Execute a SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "admin");
            ResultSet result = statement.executeQuery();

            // Step 3: Process the result
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}