import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26690_SessionManager_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        // Step 1: Establish a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 2: Use the connection to execute a session-related operation (like a SELECT query)
        if (connection != null) {
            try {
                // Assume we're doing a SELECT query to get the user's name
                String sql = "SELECT name FROM users WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, 123); // substitute the actual user id
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    System.out.println("User's name: " + name);
                } else {
                    System.out.println("No user found with the given id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Step 3: Close the connection when we're done with it
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}