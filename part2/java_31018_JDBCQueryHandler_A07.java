import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31018_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mock://username:password@localhost/db";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the driver
            Class.forName("MockDriver");

            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE Email = ?");
            statement.setString(1, "test@example.com");

            // Execute the statement
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection, statement and result set
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {}
            if (statement != null) try { statement.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
    }
}