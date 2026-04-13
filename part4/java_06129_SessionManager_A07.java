import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_06129_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session Created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session Destroyed: " + event.getSession().getId());
    }

    public static void main(String[] args) {
        // Create a new instance of the custom session manager
        CustomSessionManager manager = new CustomSessionManager();

        // Start the session
        HttpSession session = new HttpSession(manager);
        session.start();

        // Stop the session
        session.stop();
    }
}