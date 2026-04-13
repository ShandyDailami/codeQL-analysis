import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_37798_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create SQL query
            String sql = "SELECT password FROM Users WHERE username = ?";

            // Prepare statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameter
            statement.setString(1, "testUser");

            // Execute statement
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals("testPassword")) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Authentication failed.");
                }
            } else {
                System.out.println("No user found with the given username.");
            }

            // Close connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}