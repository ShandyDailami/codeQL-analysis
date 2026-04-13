import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_31555_SessionManager_A07 implements HttpSessionListener {

    private static int sessionCount = 0;

    public java_31555_SessionManager_A07() {
        System.out.println("CustomSessionManager created. Total sessions: " + sessionCount);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " created.");
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " destroyed.");
        sessionCount--;
    }

    public static int getSessionCount() {
        return sessionCount;
    }
}