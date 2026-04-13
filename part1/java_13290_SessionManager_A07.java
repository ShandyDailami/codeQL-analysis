import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_13290_SessionManager_A07 implements HttpSessionListener {

    private static int numActiveSessions = 0;

    public static int getNumActiveSessions() {
        return numActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        numActiveSessions++;
        System.out.println("Session created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        numActiveSessions--;
        System.out.println("Session destroyed: " + event.getSession().getId());
    }

    public static void main(String[] args) {
        // Add session listener to existing session context
        MySessionManager sessionManager = new MySessionManager();
        HttpSession session1 = sessionManager.createSession();
        sessionManager.destroySession(session1.getId());
        System.out.println("Number of active sessions: " + getNumActiveSessions());
    }
}