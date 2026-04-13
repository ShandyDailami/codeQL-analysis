import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_06105_SessionManager_A07 implements HttpSessionListener {

    // Create a static instance of the session manager
    private static MySessionManager instance = new MySessionManager();

    // Constructor is private to enforce singleton behavior
    private java_06105_SessionManager_A07() {}

    public static MySessionManager getInstance() {
        return instance;
    }

    // Count the number of active sessions
    private int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session created: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session destroyed: " + activeSessions);
    }

    // This method is a security-sensitive operation related to A07_AuthFailure.
    // If this method is called without a valid session, it will throw an exception.
    public void performAuthFailureSafeOperation() {
        if (activeSessions == 0) {
            throw new IllegalStateException("No active sessions. This operation is not safe.");
        }
        // Perform the operation here.
    }
}