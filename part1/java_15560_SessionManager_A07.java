import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15560_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // This method will be invoked when a new session is created
        String sessionId = se.getSession().getId();
        System.out.println("Session " + sessionId + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This method will be invoked when a session is destroyed
        String sessionId = se.getSession().getId();
        System.out.println("Session " + sessionId + " destroyed.");
    }

    public static void main(String[] args) {
        // Create a new secure session manager
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Add the session listener to the existing session context
        // This is typically done in the web.xml file
        // This is not done in this minimalist example
    }
}