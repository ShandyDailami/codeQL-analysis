import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_08563_SessionManager_A03 implements HttpSessionListener {

    // Create a static instance of the SessionManager
    private static MySessionManager instance = new MySessionManager();

    // Private constructor to restrict instantiation of this class
    private java_08563_SessionManager_A03() {
        // Initialize the SessionManager here...
    }

    public static MySessionManager getInstance() {
        return instance;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // This method is called when a new session is created.
        // We can put any initialization logic here.
        System.out.println("Session Created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This method is called when a session is destroyed.
        // We can put any cleanup logic here.
        System.out.println("Session Destroyed: " + se.getSession().getId());
   
    }
}