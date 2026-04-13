import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06560_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "admin"); // Username to check

            // Execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usernameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");
                System.out.println("Username: " + usernameDB + ", Password: " + passwordDB);
            }

            // Close connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in SQL query or driver loading: " + e.getMessage());
        }
    }
}