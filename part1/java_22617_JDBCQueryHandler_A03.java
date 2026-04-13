import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22617_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the SQL query
            String query = "SELECT * FROM users WHERE username = ?";
            statement = connection.prepareStatement(query);

            // Bind the parameter
            statement.setString(1, "testUser");

            // Execute the query
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, Statement and Connection
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {}
            if (statement != null) try { statement.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
    }
}