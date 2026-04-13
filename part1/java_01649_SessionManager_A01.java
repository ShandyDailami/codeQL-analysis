import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_01649_SessionManager_A01 implements HttpSessionListener {
    private static int activeSessionsCount = 0;

    public java_01649_SessionManager_A01() {
        // No need to do anything in constructor.
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        synchronized (this) {
            activeSessionsCount++;
            System.out.println("Session created. Active sessions count: " + activeSessionsCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        synchronized (this) {
            activeSessionsCount--;
            System.out.println("Session destroyed. Active sessions count: " + activeSessionsCount);
        }
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}