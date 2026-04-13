import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24512_JDBCQueryHandler_A07 {

    // The JDBC URL and credentials for the database.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the MySQL driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection.
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement.
            statement = connection.createStatement();

            // Execute a query.
            String query = "SELECT * FROM users WHERE username = '" + "username" + "' AND password = '" + "password" + "'";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set.
            while (resultSet.next()) {
                // Get the user ID.
                int id = resultSet.getInt("id");
                // Get the user name.
                String username = resultSet.getString("username");
                // Get the user password.
                String password = resultSet.getString("password");

                // Do something with the user information.
                System.out.println("ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection.
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}