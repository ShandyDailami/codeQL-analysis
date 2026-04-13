import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_03074_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // No action required
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        
        // Remove sensitive information from the session
        session.removeAttribute("unwantedAttribute");

        // Set a secure cookie
        session.setAttribute("secureCookie", "Secure Value");
    }
    
    public static void main(String[] args) {
        // Register this session manager
        SecureSessionManager sessionManager = new SecureSessionManager();
        // Note: This should be done in a proper context loader or servlet container
    }
}