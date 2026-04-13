import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_38828_SessionManager_A07 implements HttpSessionListener {
    
    private static int activeSessionsCount = 0;

    public static int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionsCount++;
        System.out.println("Session created: Current active sessions: " + activeSessionsCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionsCount--;
        System.out.println("Session destroyed: Current active sessions: " + activeSessionsCount);
    }

    // Example usage:
    public static void main(String[] args) {
        HttpSession session = new HttpSession();
        session.setMaxInactiveInterval(10);

        // You may want to implement a session security logic here
        // This is a simple example where if the session is idle for more than 10 minutes, it will be destroyed
        SessionManager sessionManager = new SessionManager();
        session.addHttpSessionListener(sessionManager);
    }
}