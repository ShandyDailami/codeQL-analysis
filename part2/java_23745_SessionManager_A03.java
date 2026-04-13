import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_23745_SessionManager_A03 implements HttpSessionListener {

    // Static variable for session count
    private static int numSessions = 0;

    // Constructor
    public java_23745_SessionManager_A03() {
        numSessions++;
        System.out.println("Created session: " + numSessions);
    }

    // Destructor
    public java_23745_SessionManager_A03(HttpSessionEvent se) {
        numSessions--;
        System.out.println("Closed session: " + numSessions);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
    }

    public static int getNumSessions() {
        return numSessions;
    }
}