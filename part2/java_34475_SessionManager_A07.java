import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_34475_SessionManager_A07 implements HttpSessionListener {
    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        System.out.println("Session Created with ID: " + sessionId);
        activeSessionsCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String sessionId = session.getId();
        System.out.println("Session Destroyed with ID: " + sessionId);
        activeSessionsCount--;
    }

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    public static void main(String[] args) {
        // This will create a new HttpSession and print the session ID
        HttpSession session = new HttpSession();
        System.out.println("Session ID: " + session.getId());
    }
}