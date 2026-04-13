import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33370_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_33370_SessionManager_A03() {
        // Constructor is empty
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("Session Created: Active Sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("Session Destroyed: Active Sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}