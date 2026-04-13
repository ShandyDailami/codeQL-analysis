import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_25205_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_25205_SessionManager_A07() {
        System.out.println("SessionCounter initialized.");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: " + activeSessions);
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}