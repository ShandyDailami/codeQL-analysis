import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_03386_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session Created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session Destroyed: " + event.getSession().getId());
    }

    public static void main(String[] args) {
        // Create a new instance of SessionManager and add it as a listener
        SessionManager sessionManager = new SessionManager();
        sessionManager.addListener();

        // Test session creation and destruction
        // This should print out a message for each session creation and destruction
    }

    private void addListener() {
        // Code here...
    }
}