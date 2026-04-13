import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18061_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Step 3: Prepare the SQL statement
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";

            // Step 4: Execute the SQL statement
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}