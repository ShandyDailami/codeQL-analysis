import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_01372_SessionManager_A01 implements HttpSessionListener {

    // List of active sessions
    private static java.util.List<HttpSession> activeSessions = new java.util.ArrayList<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.add(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.remove(se.getSession());
    }

    // Simulate a method that tries to change a session ID
    public void changeSessionId(HttpSession session) {
        try {
            // Attempt to create a new session with a different ID
            session.setId("newSessionId");
            session.setMaxInactiveInterval(60); // Set a new interval for the session
        } catch (IllegalStateException e) {
            // Handle the case where changing the session ID is not allowed
            System.out.println("Failed to change session ID: " + e.getMessage());
        }
    }

    // Simulate a method that tries to access a resource in a session that is not allowed
    public void accessResource(HttpSession session) {
        try {
            // Attempt to access a resource in the session
            session.setAttribute("resource", "Accessible");
        } catch (IllegalStateException e) {
            // Handle the case where access is not allowed
            System.out.println("Failed to access resource: " + e.getMessage());
        }
    }

    // Simulate a method that tries to access a resource in a session that is not allowed
    public void attemptBrokenAccess(HttpSession session) {
        try {
            // Attempt to access a resource in the session
            session.getAttribute("resource");
        } catch (IllegalStateException e) {
            // Handle the case where access is not allowed
            System.out.println("Broken access attempt: " + e.getMessage());
        }
    }
}