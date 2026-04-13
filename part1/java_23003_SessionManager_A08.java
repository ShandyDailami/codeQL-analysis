import javax.servlet.http.*;
import java.util.*;

public class java_23003_SessionManager_A08 implements HttpSessionListener {

    // HashMap to store session IDs and the HttpSession objects
    private HashMap<String, HttpSession> sessionMap = new HashMap<>();

    // This is the callback method that gets invoked every time a new session is created
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session created: " + event.getSession().getId());
        sessionMap.put(event.getSession().getId(), event.getSession());
    }

    // This is the callback method that gets invoked every time a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session destroyed: " + event.getSession().getId());
        sessionMap.remove(event.getSession().getId());
    }

    // Method to get a HttpSession object based on a session ID
    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to get all session IDs
    public List<String> getAllSessionIds() {
        return new ArrayList<>(sessionMap.keySet());
    }
}