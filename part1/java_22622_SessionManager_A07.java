import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

public class java_22622_SessionManager_A07 implements HttpSessionListener {
    private static Set<String> activeSessions = new HashSet<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.add(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.remove(se.getSession().getId());
    }

    public static boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }
}