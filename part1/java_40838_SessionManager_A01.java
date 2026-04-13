import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_40838_SessionManager_A01 implements HttpSessionListener {
    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        synchronized (this) {
            activeSessionsCount++;
            System.out.println("Session created: " + activeSessionsCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        synchronized (this) {
            activeSessionsCount--;
            System.out.println("Session destroyed: " + activeSessionsCount);
        }
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}