import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_08862_SessionManager_A03 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_08862_SessionManager_A03() {
        // Empty constructor
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
   
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}