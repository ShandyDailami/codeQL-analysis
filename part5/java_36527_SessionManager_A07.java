import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_36527_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessionsCount++;
        System.out.println("Session created: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessionsCount--;
        System.out.println("Session destroyed: " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}