import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_02933_SessionManager_A07 implements HttpSessionListener {

    // This method is called whenever a new session is created
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session created: " + session.getId());
    }

    // This method is called whenever an existing session is accessed
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session accessed: " + session.getId());
    }

    // This method is called whenever an existing session is invalidated
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        System.out.println("Session destroyed: " + session.getId());
    }
}