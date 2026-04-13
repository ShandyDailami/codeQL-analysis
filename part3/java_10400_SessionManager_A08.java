import java.sql.SQLException;

public class java_10400_SessionManager_A08 {
    private Session session;

    public void openSession() {
        try {
            session = SessionFactory.getSession();
            System.out.println("Session Opened");
        } catch (SQLException e) {
            System.out.println("Failed to open Session");
       .
.
.
.
            // Handling the exception here
        }
    }

    public void closeSession() {
        if (session != null) {
            try {
                session.close();
                System.out.println("Session Closed");
            } catch (SQLException e) {
                System.out.println("Failed to close Session");
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.openSession();
        manager.openSession(); // This should print a message saying "Session already opened"
        manager.closeSession();
        manager.closeSession(); // This should print a message saying "Session already closed"
    }
}