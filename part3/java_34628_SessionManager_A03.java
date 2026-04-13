import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_34628_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    // This method is called when a session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created. Current number of active sessions: " + activeSessions);
    }

    // This method is called when a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed. Current number of active sessions: " + activeSessions);
    }

    // A simple method to check the current number of active sessions
    public static int getActiveSessions() {
        return activeSessions;
    }
}