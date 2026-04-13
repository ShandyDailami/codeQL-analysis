import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_07787_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessionsCount;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessionsCount++;
        System.out.println("Session Created: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessionsCount--;
        System.out.println("Session Destroyed: " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}