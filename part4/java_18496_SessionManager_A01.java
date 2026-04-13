import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_18496_SessionManager_A01 implements HttpSessionListener {

    private int activeSessions;

    public java_18496_SessionManager_A01() {
        activeSessions = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created. Total active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed. Total active sessions: " + activeSessions);
    }

    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();
        System.out.println("Total active sessions at startup: " + sessionManager.activeSessions);

        // Add session listener to handle session events
        System.out.println("Adding session listener...");
        System.out.println("Total active sessions at the end: " + sessionManager.activeSessions);
    }
}