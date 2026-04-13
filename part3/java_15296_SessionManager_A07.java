import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15296_SessionManager_A07 implements HttpSessionListener {

    // Counting number of active sessions
    private int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }

    // This method checks if the session is in an invalid state
    public boolean isSessionInvalid(HttpSessionEvent event) {
        return event.getSession().getLastAccessedTime() < System.currentTimeMillis() - 300000;
    }

}