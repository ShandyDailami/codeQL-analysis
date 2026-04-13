import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_14902_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session Created: " + session.getId());
        activeSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session Destroyed: " + session.getId());
        activeSessions--;
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}