import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_05911_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare a SQL query
            String sql = "SELECT * FROM users WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "admin"); // Use admin as the username

            // Execute the query
            statement.executeUpdate();

            // Handle the result
            // ...

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
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