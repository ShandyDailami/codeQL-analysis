// Importing the required libraries
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_36054_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session Created: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session Destroyed: " + activeSessionsCount);
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }
}