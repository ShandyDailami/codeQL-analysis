import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_38382_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session created: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session destroyed: " + activeSessionsCount);
    }

    public static void main(String[] args) {
        // Create a new session
        HttpSession session = new HttpSession(null);

        // Print the active sessions count
        System.out.println("Initial active sessions count: " + getActiveSessionsCount());

        // Test session destroy event
        session.invalidate();
        System.out.println("Final active sessions count: " + getActiveSessionsCount());
    }
}