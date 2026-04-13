import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_01974_SessionManager_A07 implements HttpSessionListener {

    private int activeSessions = 0;

    public java_01974_SessionManager_A07() {
        // Initialization code here if needed
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("New session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }

    public int getActiveSessions() {
        return activeSessions;
    }
}