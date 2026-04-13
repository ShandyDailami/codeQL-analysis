import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_21229_SessionManager_A01 implements HttpSessionListener {

    // Create a private static instance of the SessionManager
    private static SessionManager sessionManager;
    
    // Constructor
    private java_21229_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session " + session.getId() + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session " + session.getId() + " destroyed.");
    }
}