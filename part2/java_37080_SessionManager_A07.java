import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_37080_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession newSession = se.getSession();
        activeSessions++;
        System.out.println("Session Created for User: " + newSession.getAttribute("user"));
        System.out.println("Active Sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession oldSession = se.getSession();
        activeSessions--;
        System.out.println("Session Destroyed for User: " + oldSession.getAttribute("user"));
        System.out.println("Active Sessions: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}