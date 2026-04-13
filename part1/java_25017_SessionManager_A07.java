import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_25017_SessionManager_A07 implements HttpSessionListener {

    private static int totalSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        totalSessions++;
        System.out.println("Session created: " + totalSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        totalSessions--;
        System.out.println("Session destroyed: " + totalSessions);
    }

    public static int getTotalSessions() {
        return totalSessions;
    }
}