import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33983_SessionManager_A07 implements HttpSessionListener {
    
    private static int onlineCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(60); // Set a time interval for session inactivity
        synchronized (SessionManager.class) {
            onlineCount++;
        }
        System.out.println("New session created, total sessions: " + onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        synchronized (SessionManager.class) {
            onlineCount--;
        }
        System.out.println("Session " + session.getId() + " has been destroyed. Current online sessions: " + onlineCount);
    }
}