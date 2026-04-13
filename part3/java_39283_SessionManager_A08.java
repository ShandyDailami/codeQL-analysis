import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39283_SessionManager_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    private static Connection connection;

    // Method to establish a database connection
    public Connection establishConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot connect to database");
        }
        return connection;
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new session
    public void createSession() {
        try {
            connection.createStatement().execute("START TRANSACTION");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to commit the session
    public void commitSession() {
        try {
            connection.createStatement().execute("COMMIT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to rollback the session
    public void rollbackSession() {
        try {
            connection.createStatement().execute("ROLLBACK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the session
    public void closeSession() {
        try {
            connection.createStatement().execute("END");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}