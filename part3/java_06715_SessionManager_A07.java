import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_06715_SessionManager_A07 implements HttpSessionListener {

    // Define a flag to indicate if a session is active
    private static boolean sessionActive = false;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionActive = true;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionActive = false;
    }

    // Method to check if a session is active
    public boolean isSessionActive() {
        return sessionActive;
    }

    // Main method to test the session manager
    public static void main(String[] args) {
        HttpSession session = new HttpSession(); // Create a new session
        LegacySessionManager sessionManager = new LegacySessionManager(); // Create a new session manager

        // Add the session listener
        session.addListener(sessionManager);

        // Check if the session is active
        if (sessionManager.isSessionActive()) {
            System.out.println("Session is active");
        } else {
            System.out.println("Session is NOT active");
        }
    }
}