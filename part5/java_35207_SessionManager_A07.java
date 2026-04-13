import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35207_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: Current number of active sessions is: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: Current number of active sessions is: " + activeSessions);
    }

    public static void main(String[] args) {
        // No need to run main method for this task, this is just a simple example.
        // In a real-world scenario, you should use a framework like Spring or Hibernate for managing sessions.
    }
}