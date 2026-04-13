import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_15561_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "user_name";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare a statement
            statement = connection.prepareStatement("SELECT * FROM Users WHERE UserName = ?");
            statement.setString(1, "testUser");

            // Execute the query
            resultSet = statement.executeQuery();

            // Process the result
            while (resultSet.next()) {
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("Password");
                System.out.println("User Name: " + userName);
                System.out.println("Password: " + password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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