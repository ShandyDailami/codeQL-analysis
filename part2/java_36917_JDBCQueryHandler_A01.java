import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36917_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Connection object
    private Connection connection;

    // Method to connect to the database
    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SQL query
    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Method to handle exceptions
    public void handleException(SQLException e) {
        e.printStackTrace();
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");
        // Handle the resultSet
    }
}