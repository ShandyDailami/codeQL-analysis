import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35020_SessionManager_A01 implements HttpSessionListener {
    // Singleton SessionManager instance
    private static SessionManager sessionManager;
    
    // Private constructor to prevent instantiation
    private java_35020_SessionManager_A01() {}
    
    // Singleton getter
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // Create a new session
        System.out.println("Session created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Destroy a session
        System.out.println("Session destroyed: " + event.getSession().getId());
   
    }
}