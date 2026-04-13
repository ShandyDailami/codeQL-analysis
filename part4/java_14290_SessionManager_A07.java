import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_14290_SessionManager_A07 implements HttpSessionListener {

    // Constructor
    public java_14290_SessionManager_A07() {

    }

    // Method to be called when a session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
    }

    // Method to be called when a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
    }
}