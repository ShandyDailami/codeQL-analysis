import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_36369_SessionManager_A03 implements HttpSessionListener {
    private static int numSessions = 0;

    public static int getNumSessions() {
        return numSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        numSessions++;
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        numSessions--;
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a new session
        HttpSession session1 = manager.createSession();

        // Create another session
        HttpSession session2 = manager.createSession();

        // Print the number of active sessions
        System.out.println("Number of active sessions: " + SessionManager.getNumSessions());
    }

    public HttpSession createSession() {
        return this.createSession(false);
    }

    public HttpSession createSession(boolean validate) {
        HttpSession session = null;

        if (validate) {
            session = this.getSession(true);
        } else {
            session = this.getSession(false);
        }

        return session;
    }
}