import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15242_SessionManager_A03 implements HttpSessionListener {

    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessionCount++;
        System.out.println("Session " + sessionCount + " created. Total sessions: " + sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessionCount--;
        System.out.println("Session " + session + " destroyed. Total sessions: " + sessionCount);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        // Start with a single session to demonstrate the listener
        new HttpSessionImpl(sessionManager);
    }
}