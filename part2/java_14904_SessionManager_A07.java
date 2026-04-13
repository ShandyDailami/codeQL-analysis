import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_14904_SessionManager_A07 implements HttpSessionListener {
    
    private static int activeSessions = 0;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }

    public static void main(String[] args) {
        // Create a new session
        HttpSession session = new HttpSession(null);
        // Add the listener to the session
        session.addListener(new SessionManager());
    }
}