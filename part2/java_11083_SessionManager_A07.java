import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_11083_SessionManager_A07 implements HttpSessionListener {

    private static final long serialVersionUID = 1L;

    public static class SessionCounter {
        private int numSessions = 0;

        public synchronized void addSession() {
            numSessions++;
        }

        public synchronized void removeSession() {
            numSessions--;
        }

        public synchronized int getSessionCount() {
            return numSessions;
        }
    }

    private static SessionCounter sessionCounter = new SessionCounter();

    public java_11083_SessionManager_A07() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCounter.addSession();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCounter.removeSession();
    }
}