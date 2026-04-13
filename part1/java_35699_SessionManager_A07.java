import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35699_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Initialize session with a unique id
        session.setAttribute("sessionId", session.getId());
        // Adding a secret information in the session
        session.setAttribute("secretInfo", "This is a secret information");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Cleanup code here if necessary
    }

    public static void main(String[] args) {
        // Adding session listener
        CustomSessionListener sessionListener = new CustomSessionListener();
        HttpSessionListener httpSessionListener = sessionListener;
    }
}