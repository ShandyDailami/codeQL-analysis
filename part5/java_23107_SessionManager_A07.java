import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_23107_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        // Use ServletContextListener or ServletContextEvent in place of HttpSessionListener
        // Example:
        // ServletContextListener listener = new SessionCounter();
        // servletContext.addListener(listener);
    }
}