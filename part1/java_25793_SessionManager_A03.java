import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25793_SessionManager_A03 {
    // Database credentials
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/db";

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Constructor to initialize the database credentials
    public java_25793_SessionManager_A03() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find JDBC driver", e);
        }
    }

    // Method to open a database connection
    public Connection openConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot open database connection", e);
        }
    }

    // Method to close a database connection
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            // Do nothing
        }
    }
}