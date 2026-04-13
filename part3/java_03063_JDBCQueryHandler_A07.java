import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03063_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the statement for inserting a new user
            String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertUserQuery);
            preparedStatement.setString(1, "newUser");
            preparedStatement.setString(2, "password");
            preparedStatement.executeUpdate();

            // Read the inserted user
            String selectUserQuery = "SELECT * FROM users WHERE username = ?";
            preparedStatement = connection.prepareStatement(selectUserQuery);
            preparedStatement.setString(1, "newUser");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}