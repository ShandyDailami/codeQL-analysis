import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39931_SessionManager_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public java_39931_SessionManager_A07() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            establishConnection();
        }
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
        SecureSessionManager sessionManager = new SecureSessionManager();
        try {
            Connection connection = sessionManager.getConnection();
            // here you can execute any secure operations related to authentication
            // for example:
            connection.createStatement().execute("SELECT * FROM Users");
            // if any exception occurs, it will be caught and handled
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeConnection();
        }
    }
}