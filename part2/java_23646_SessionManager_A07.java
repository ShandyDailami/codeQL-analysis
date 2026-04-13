import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_23646_SessionManager_A07 implements HttpSessionListener {

    // Instance variable to keep track of the number of active sessions.
    private static int numActiveSessions = 0;

    // Static variable to check if a session is active or not.
    private static boolean isSessionActive = false;

    // This method will be called whenever a new session is created.
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        numActiveSessions++;
        isSessionActive = true;
        System.out.println("Session " + numActiveSessions + " created.");
    }

    // This method will be called whenever an existing session is accessed.
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        numActiveSessions--;
        isSessionActive = false;
        System.out.println("Session " + numActiveSessions + " destroyed.");
    }

    // Method to validate a session. This method will be called every time a session is accessed.
    public static boolean isSessionValid(HttpSession session) {
        if (session == null || !session.isPresent() || !session.getAttribute("username") != null) {
            return false;
        }
        // In a real-world scenario, you would also need to check other factors like user permissions.
        return true;
    }

    public static int getActiveSessions() {
        return numActiveSessions;
    }

    public static boolean isSessionActive() {
        return isSessionActive;
    }
}