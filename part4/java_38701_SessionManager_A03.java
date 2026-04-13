import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_38701_SessionManager_A03 implements HttpSessionListener {

    // Static array to hold all the session IDs
    private static String[] activeSessions = new String[10];
    private static int activeSessionsCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Add session ID to the array
        activeSessions[activeSessionsCount] = se.getSession().getId();
        activeSessionsCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Remove session ID from the array
        for (int i = 0; i < activeSessionsCount; i++) {
            if (activeSessions[i].equals(se.getSession().getId())) {
                System.arraycopy(activeSessions, i + 1, activeSessions, i, activeSessionsCount - i - 1);
                activeSessionsCount--;
                break;
            }
        }
    }

    // Method to check if a session ID is in the array
    public static boolean isSessionActive(String sessionId) {
        for (int i = 0; i < activeSessionsCount; i++) {
            if (activeSessions[i].equals(sessionId)) {
                return true;
            }
        }
        return false;
    }
}