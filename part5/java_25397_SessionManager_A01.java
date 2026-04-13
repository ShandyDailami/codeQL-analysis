import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_25397_SessionManager_A01 implements HttpSessionListener {

    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        System.out.println("Session " + sessionCount + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        System.out.println("Session " + se.getSession().getId() + " destroyed.");
    }

    public static void main(String[] args) {
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        CustomSessionManager sessionManager = new CustomSessionManager();

        // Create a session
        HttpSession session = request.getSession(true);

        // Register the session listener
        session.addListener(sessionManager);

        // Destroy the session
        session.invalidate();
    }
}