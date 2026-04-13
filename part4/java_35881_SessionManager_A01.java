import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35881_SessionManager_A01 implements HttpSessionListener {

    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessionsCount++;
        System.out.println("Session Created: " + activeSessionsCount + " active sessions");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessionsCount--;
        System.out.println("Session Destroyed: " + activeSessionsCount + " active sessions");
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

}