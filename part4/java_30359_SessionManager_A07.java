import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_30359_SessionManager_A07 implements HttpSessionListener {

    private int numActiveSessions = 0;

    public java_30359_SessionManager_A07() {
    }

    public void sessionCreated(HttpSessionEvent se) {
        numActiveSessions++;
        System.out.println("Session Created. Number of active sessions: " + numActiveSessions);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        numActiveSessions--;
        System.out.println("Session Destroyed. Number of active sessions: " + numActiveSessions);
    }

    public int getNumActiveSessions() {
        return numActiveSessions;
    }
}