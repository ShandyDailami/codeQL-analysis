import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15618_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session created: Currently active sessions = " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session destroyed: Currently active sessions = " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}