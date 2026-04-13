import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_12837_SessionManager_A07 implements HttpSessionListener {
    private static int activeSessions;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: Active Sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: Active Sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}