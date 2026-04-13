import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_40242_SessionManager_A08 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_40242_SessionManager_A08() {
        System.out.println("Initializing Secure Session Manager...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions++;
        System.out.println("Session Created: " + session.getId());
        System.out.println("Active Sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions--;
        System.out.println("Session Destroyed: " + session.getId());
        System.out.println("Active Sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        // Create a new instance of SecureSessionManager
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Start the server
        // (This is just a placeholder, not a real server)
        System.out.println("Server started...");
    }
}