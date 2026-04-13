import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35639_SessionManager_A07 implements HttpSessionListener {

    private int activeSessions;

    public java_35639_SessionManager_A07() {
        activeSessions = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("New session created. Active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("Session destroyed. Active sessions: " + activeSessions);
    }

    public int getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Example of using session listener
        HttpSessionEvent event = new HttpSessionEvent(null);
        sessionManager.sessionCreated(event);
        sessionManager.sessionDestroyed(event);

        System.out.println("Active sessions: " + sessionManager.getActiveSessions());
    }
}