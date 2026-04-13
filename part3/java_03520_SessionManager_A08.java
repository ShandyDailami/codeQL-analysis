import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_03520_SessionManager_A08 implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions++;
        System.out.println("Session " + session.getId() + " created. Active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions--;
        System.out.println("Session " + session.getId() + " destroyed. Active sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}