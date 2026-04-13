import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class java_39902_SessionManager_A01 implements HttpSessionListener {
    private Map<String, HttpSession> sessionMap;

    public java_39902_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        sessionMap.remove(session.getId());
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Start a session
        HttpSession session1 = sessionManager.startSession();

        // Attempt to access a protected method
        session1.setAttribute("protectedAttribute", "Some Value");

        // Stop the session
        sessionManager.stopSession(session1.getId());

        // Attempt to access a protected method again
        try {
            session1.setAttribute("protectedAttribute", "Some New Value");
        } catch (IllegalStateException e) {
            System.out.println("Failed to access protected attribute: " + e.getMessage());
        }
    }
}