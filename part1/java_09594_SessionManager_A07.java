import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_09594_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: Current active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: Current active sessions: " + activeSessions);
    }

    public static void main(String[] args) {
        // In a real application, you would want to use a ServletContextListener
        // to register the SessionManager as a listener to session events.
        // However, since this is a simple example, we can just start the application here.
        // Just start up a servlet container (like Tomcat) and visit the URLs in your browser to see the sessions in action.
        // The SessionManager will print out the number of active sessions whenever a session is created or destroyed.
        new SessionManager();
    }
}