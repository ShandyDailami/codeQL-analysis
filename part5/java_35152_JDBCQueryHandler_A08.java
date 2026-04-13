import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_35152_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a new user
            String createUserSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement createStatement = connection.prepareStatement(createUserSQL);
            createStatement.setString(1, "newUser");
            createStatement.setString(2, "password");
            createStatement.executeUpdate();

            // Step 4: Check if the user exists
            String checkUserSQL = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkUserSQL);
            checkStatement.setString(1, "newUser");
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }

            // Step 5: Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}