import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_18177_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    // this method will be called when a new session is created
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions++;
        System.out.println("Session created. Active sessions: " + activeSessions);
    }

    // this method will be called when a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        activeSessions--;
        System.out.println("Session destroyed. Active sessions: " + activeSessions);
    }

    // method to check the active sessions
    public static int getActiveSessions() {
        return activeSessions;
    }
}