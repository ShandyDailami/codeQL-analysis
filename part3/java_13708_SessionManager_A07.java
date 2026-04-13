import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

public class java_13708_SessionManager_A07 implements HttpSessionListener {

    private static final Set<HttpSession> activeSessions = new HashSet<>();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions.add(event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions.remove(event.getSession());
    }

    public static boolean isSessionActive(HttpSession session) {
        return activeSessions.contains(session);
    }

    public static HttpSession getSessionByUser(String username) {
        for (HttpSession session : activeSessions) {
            if (session.getAttribute("username").equals(username)) {
                return session;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a session
        // ...

        // Check if the session is active
        // ...

        // Get a session by user
        // ...
    }
}