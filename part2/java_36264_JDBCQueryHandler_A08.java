import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36264_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/userDB";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a SQL query
            String sql = "SELECT * FROM user_table WHERE password = ?";

            // Step 4: Prepare the statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 5: Execute the statement
            statement.setString(1, "integrityFailure"); // Replace with actual password
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Handle the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 7: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}