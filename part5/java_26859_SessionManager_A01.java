import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_26859_SessionManager_A01 implements HttpSessionListener {

    // This method is called when a new session is created
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session " + session.getId() + " created.");
    }

    // This method is called when a session is terminated
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session " + session.getId() + " destroyed.");
    }
}