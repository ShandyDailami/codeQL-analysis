import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05308_SessionManager_A01 {
    private static Connection connection;

    // Loading the driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Opening a connection
    private static Connection openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Closing the connection
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = openConnection();
        // Perform operations here
        closeConnection(connection);
    }
}