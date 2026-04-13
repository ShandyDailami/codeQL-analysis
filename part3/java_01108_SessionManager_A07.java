import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionContext;
import java.util.HashSet;
import java.util.Set;

public class java_01108_SessionManager_A07 implements HttpSessionListener {

    private static final Set<HttpSession> activeSessions = new HashSet<>();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions.add(event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions.remove(event.getSession());
    }

    public static int getActiveSessionCount() {
        return activeSessions.size();
    }

    public static boolean isSessionValid(HttpSession session) {
        return activeSessions.contains(session);
    }

}