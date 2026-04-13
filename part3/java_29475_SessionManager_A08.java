import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29475_SessionManager_A08 {
    private Connection connection;

    public java_29475_SessionManager_A08() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void openSession() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession();
        sessionManager.closeSession();
    }
}