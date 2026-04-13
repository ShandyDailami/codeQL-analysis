import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_41644_SessionManager_A07 implements HttpSessionListener {

    private int activeSessionsCount;

    public java_41644_SessionManager_A07() {
        activeSessionsCount = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("New session created. Total active sessions: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session destroyed. Total active sessions: " + activeSessionsCount);
    }
}