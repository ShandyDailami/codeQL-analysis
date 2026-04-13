import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_30675_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    // Implementing HttpSessionListener
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("New session created with ID: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session with ID: " + se.getSession().getId() + " has been destroyed. Currently active sessions: " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}