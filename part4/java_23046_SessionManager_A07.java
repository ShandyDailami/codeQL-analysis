import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_23046_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    public java_23046_SessionManager_A07() {
        // Constructor
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session created: " + session.getId());
        activeSessionsCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session destroyed: " + session.getId());
        activeSessionsCount--;
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}