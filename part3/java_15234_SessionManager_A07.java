import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15234_SessionManager_A07 implements HttpSessionListener {

    // Counter to keep track of active sessions
    private static int counter = 0;

    public java_15234_SessionManager_A07() {
        counter++;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " created. Total active sessions: " + counter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " destroyed. Total active sessions: " + --counter);
    }

    public static void main(String[] args) {
        // Create and start a session
        MySessionManager sessionManager = new MySessionManager();
        // ... do something with the sessionManager ...
    }
}