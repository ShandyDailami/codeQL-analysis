import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16559_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test"; // replace with your database URL
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Open a statement
            statement = connection.createStatement();

            // Execute a query
            resultSet = statement.executeQuery("SELECT password FROM users WHERE username = 'test'");

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                System.out.println("Password: " + password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignore */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* ignore */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignore */ }
        }
    }
}