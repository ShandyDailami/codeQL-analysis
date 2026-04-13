import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33652_SessionManager_A01 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        // Add code here to handle session creation
        System.out.println("Session " + session.getId() + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        // Add code here to handle session destruction
        System.out.println("Session " + session.getId() + " destroyed.");
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();
        // Start the session manager
        // Add code here to start the session manager
    }
}