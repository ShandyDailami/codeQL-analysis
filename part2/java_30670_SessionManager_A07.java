import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_30670_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session Created: Current active sessions: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session Destroyed: Current active sessions: " + activeSessionsCount);
    }
}