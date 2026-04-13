import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_04631_SessionManager_A07 implements HttpSessionListener {

    private int activeSessions;

    public java_04631_SessionManager_A07() {
        activeSessions = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("Session Created: Current number of active sessions is: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("Session Destroyed: Current number of active sessions is: " + activeSessions);
    }

    // Add a method to get the number of active sessions
    public int getActiveSessions() {
        return activeSessions;
    }
}