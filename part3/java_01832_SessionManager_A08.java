import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_01832_SessionManager_A08 implements HttpSessionListener {

    private static final long serialVersionUID = 1L;

    // List of all sessions
    private static List<HttpSession> allSessions = new ArrayList<>();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        allSessions.add(session);
        System.out.println("Session created: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        allSessions.remove(session);
        System.out.println("Session destroyed: " + session.getId());
    }

    // Method to check if a session has a valid id
    public static boolean isSessionValid(String sessionId) {
        for (HttpSession session : allSessions) {
            if (session.getId().equals(sessionId)) {
                return true;
            }
        }
        return false;
    }

    // Method to get the session if it's valid
    public static HttpSession getSession(String sessionId) {
        for (HttpSession session : allSessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }
}