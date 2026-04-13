import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_31444_SessionManager_A03 implements HttpSessionListener {

    private int sessionCount;

    public java_31444_SessionManager_A03() {
        sessionCount = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed: " + se.getSession().getId());
        sessionCount--;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public static void main(String[] args) {
        HttpSession session = new SessionManager().createSession();
        // Use the session object for security-sensitive operations here.
        System.out.println("Session created: " + session.getId());
    }

    private HttpSession createSession() {
        // You would typically use a HttpServletRequest object to create a session.
        // For simplicity, we'll just use this method.
        return new SessionManager().getSession(true);
    }
}