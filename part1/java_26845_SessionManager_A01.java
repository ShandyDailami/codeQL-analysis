import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_26845_SessionManager_A01 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // This method is called when a new session is created
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        System.out.println("Created session with ID: " + sessionId);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // This method is called when a session is destroyed
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        System.out.println("Destroyed session with ID: " + sessionId);
    }

    // Add more session-related methods as needed

}