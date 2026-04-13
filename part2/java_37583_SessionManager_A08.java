import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37583_SessionManager_A08 {
    private Connection connection;

    public void openConnection(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void secureOperation() throws IntegrityFailureException {
        // Simulate a security-sensitive operation
        if (/* operation is not successful */) {
            throw new IntegrityFailureException("Operation failed due to integrity failure");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.openConnection("jdbc:mysql://localhost/test", "username", "password");

        try {
            manager.secureOperation();
        } catch (IntegrityFailureException e) {
            System.out.println(e.getMessage());
        }

        manager.closeConnection();
    }
}

class IntegrityFailureException extends Exception {
    public java_37583_SessionManager_A08(String message) {
        super(message);
    }
}