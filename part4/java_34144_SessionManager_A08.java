import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_34144_SessionManager_A08 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session created: Current count is " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session destroyed: Current count is " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}