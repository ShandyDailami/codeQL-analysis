import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_14182_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    // Method to log the event
    private static void log(String message) {
        System.out.println("[SessionManager] " + message);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log("Session created: " + session.getId());
        activeSessionsCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log("Session destroyed: " + session.getId());
        activeSessionsCount--;
    }

    // For testing purposes
    public static void main(String[] args) {
        HttpSession session = new HttpSession(null);
        SessionManager sm = new SessionManager();
        sm.sessionCreated(new HttpSessionEvent(session));
        sm.sessionDestroyed(new HttpSessionEvent(session));

        System.out.println("Active sessions count: " + SessionManager.getActiveSessionsCount());
    }
}