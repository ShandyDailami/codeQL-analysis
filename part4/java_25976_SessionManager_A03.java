import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_25976_SessionManager_A03 implements HttpSessionListener {

    // This is a static instance of the session manager
    private static SessionManager instance = new SessionManager();

    // Private constructor to prevent instantiation of this class
    private java_25976_SessionManager_A03() {}

    // Singleton instance access method
    public static SessionManager getInstance() {
        return instance;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session Created: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session Destroyed: " + session.getId());
    }
}