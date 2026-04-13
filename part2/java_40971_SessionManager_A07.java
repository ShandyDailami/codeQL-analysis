import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_40971_SessionManager_A07 implements HttpSessionListener {

    private int activeSessions;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created. Total active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed. Total active sessions: " + activeSessions);
   
    }

    public static void main(String[] args) {
        // This is where we create a new instance of our session manager
        HttpSessionManager sessionManager = new HttpSessionManager();

        // This is where we register our session manager as a listener for session events
        sessionManager.addSessionListener(new MySessionManager());
    }
}