import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32374_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL Connector/J Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the statement
            statement = connection.prepareStatement("SELECT * FROM Users");

            // Step 4: Execute the statement and get the result set
            resultSet = statement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (resultSet != null) try { resultSet.close(); } catch(SQLException e) {}
            if (statement != null) try { statement.close(); } catch(SQLException e) {}
            if (connection != null) try { connection.close(); } catch(SQLException e) {}
        }
    }
}