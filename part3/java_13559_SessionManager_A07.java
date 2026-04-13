import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_13559_SessionManager_A07 implements HttpSessionListener {

    private static final String SECURITY_KEY = "customSecurityKey";

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Set a key-value pair in the session
        session.setAttribute("customSessionAttribute", "This is custom session data");
        // Set a security key in the session
        session.setAttribute("securityKey", SECURITY_KEY);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Remove the security key from the session
        session.removeAttribute("securityKey");
    }
}