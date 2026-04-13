import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_27385_SessionManager_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement for a simple SELECT operation
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin"); // The username "admin" here is used as a placeholder

            // Step 4: Execute the statement and obtain a ResultSet
            ResultSet result = statement.executeQuery();

            // Step 5: Process the ResultSet
            while (result.next()) {
                String dbUsername = result.getString("username");
                System.out.println("Username in the database: " + dbUsername);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}