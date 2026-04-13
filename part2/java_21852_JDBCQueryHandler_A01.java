import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21852_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_21852_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to database.");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error: Unable to execute query.");
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Unable to close connection.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler with a valid database connection
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Execute a query
        ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM Users");

        // Process the results
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            // Perform security-sensitive operations here...
        }

        // Close the connection
        jdbcHandler.closeConnection();
    }
}