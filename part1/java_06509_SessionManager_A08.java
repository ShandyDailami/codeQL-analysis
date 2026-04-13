import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06509_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_06509_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                connection = null;
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        try {
            manager.getConnection().createStatement().execute("DROP TABLE Employee"); // Assume the table exists and is not empty
        } catch (SQLException e) {
            e.printStackTrace();
        }
        manager.closeConnection();
    }
}