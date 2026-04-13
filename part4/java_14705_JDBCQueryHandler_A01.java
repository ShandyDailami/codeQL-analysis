import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14705_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            resultSet = statement.executeQuery("SELECT * FROM users WHERE password = 'password'");

            // Handle the result set
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* do nothing */}
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* do nothing */}
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* do nothing */}
        }
    }
}