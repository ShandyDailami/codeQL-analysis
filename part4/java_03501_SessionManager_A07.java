import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_03501_SessionManager_A07 implements HttpSessionListener {

    // Create a static instance of the class
    private static MySessionManager instance = null;

    // Private constructor to prevent instantiation of the class
    private java_03501_SessionManager_A07() {
    }

    // Singleton instance getter
    public static MySessionManager getInstance() {
        if (instance == null) {
            instance = new MySessionManager();
        }
        return instance;
    }

    // Private array to hold sessions
    private HttpSession[] sessions = new HttpSession[10];

    // Index to use when adding a session
    private int currentIndex = 0;

    // Implementation of the HttpSessionListener interface

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if (currentIndex == sessions.length) {
            HttpSession[] newSessions = new HttpSession[sessions.length * 2];
            System.arraycopy(sessions, 0, newSessions, 0, sessions.length);
            sessions = newSessions;
        }
        sessions[currentIndex] = se.getSession();
        currentIndex++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Remove session from array
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] == se.getSession()) {
                System.arraycopy(sessions, i + 1, sessions, i, sessions.length - i - 1);
                sessions[sessions.length - 1] = null;
                break;
            }
        }
    }
}