import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35862_SessionManager_A07 implements HttpSessionListener {
    
    private static int activeSessions = 0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        activeSessions++;
        System.out.println("Session created: " + session.getId() + ". Active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        activeSessions--;
        System.out.println("Session destroyed: " + session.getId() + ". Active sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}