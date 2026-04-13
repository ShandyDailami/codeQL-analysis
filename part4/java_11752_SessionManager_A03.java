import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11752_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // private constructor to prevent instantiation
    private java_11752_SessionManager_A03() {
        // Establish a connection to a database
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();

        // Perform some operations...

        sm.closeConnection();
    }
}