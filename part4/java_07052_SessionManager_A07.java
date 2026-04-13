import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_07052_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: Active Sessions = " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: Active Sessions = " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        // You could also create a separate thread here for managing sessions.
        // For example:
        // Thread sessionManager = new Thread(new SessionManager());
        // sessionManager.start();
    }
}