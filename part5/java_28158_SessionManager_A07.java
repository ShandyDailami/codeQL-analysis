import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_28158_SessionManager_A07 implements HttpSessionListener {
    // A static counter for the number of sessions
    private static int numSessions = 0;

    public static int getSessionCount() {
        return numSessions;
    }

    // Listener methods

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        numSessions++;
        System.out.println("Session Created: " + numSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        numSessions--;
        System.out.println("Session Destroyed: " + numSessions);
    }

    // Main method
    public static void main(String[] args) {
        // Create a new HttpSession and add this listener
        HttpSession session = new HttpSession(true);
        session.addListener(new SessionManager());

        // Start a new HttpSession
        HttpSession newSession = new HttpSession(true);

        // Print the current session count
        System.out.println("Current session count: " + getSessionCount());
    }
}