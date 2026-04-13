import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_21907_SessionManager_A03 implements HttpSessionListener {
    private static final String SESSION_DATA = "session_data";

    public static void main(String[] args) {
        HttpSession session = new MySessionManager().createSession();

        // Store data in session
        session.setAttribute(SESSION_DATA, "Hello, World!");

        // Retrieve and print data from session
        System.out.println("Retrieved data: " + session.getAttribute(SESSION_DATA));

        // Remove session
        session.invalidate();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Not used in this example
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Not used in this example
    }

    private HttpSession createSession() {
        return new MySessionManager().createSession();
    }

    private HttpSession createSession() {
        return new MySessionManager().createSession();
    }

    private class MySessionManager implements HttpSessionListener {
        @Override
        public void sessionCreated(HttpSessionEvent se) {
            // Not used in this example
        }

        @Override
        public void sessionDestroyed(HttpSessionEvent se) {
            // Not used in this example
        }

        private HttpSession createSession() {
            return javax.servlet.http.HttpSessionFactory.class.newInstance();
        }
    }
}