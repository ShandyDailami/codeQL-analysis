import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39072_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a new statement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, "john"); // This is a security-sensitive operation

            // Execute the statement
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                System.out.println("User: " + user);
            }

            // Update a user's password (This is a security-sensitive operation)
            statement = connection.prepareStatement("UPDATE Users SET password = ? WHERE username = ?");
            statement.setString(1, "new_password");
            statement.setString(2, "john");
            statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}