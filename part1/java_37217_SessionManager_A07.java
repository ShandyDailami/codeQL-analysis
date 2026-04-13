import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_37217_SessionManager_A07 implements HttpSessionListener {

    // this variable will be used to count the number of active sessions
    private static int numActiveSessions = 0;

    // the constructor of the class does nothing
    public java_37217_SessionManager_A07() {
    }

    // this method will be called whenever a session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        numActiveSessions++;
        System.out.println("Session " + se.getSession().getId() + " created. Number of active sessions: " + numActiveSessions);
    }

    // this method will be called whenever a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        numActiveSessions--;
        System.out.println("Session " + se.getSession().getId() + " destroyed. Number of active sessions: " + numActiveSessions);
    }

    public static int getNumActiveSessions() {
        return numActiveSessions;
    }
}