import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_18999_SessionManager_A03 implements HttpSessionListener {

    private int totalSessions;
    private int maxSessions;

    public java_18999_SessionManager_A03(int maxSessions) {
        this.maxSessions = maxSessions;
        this.totalSessions = 0;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        totalSessions++;
        if (totalSessions > maxSessions) {
            System.out.println("Session limit reached. Session ID: " + se.getSession().getId());
            se.getSession().invalidate();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        totalSessions--;
    }

    public static void main(String[] args) {
        int maxSessions = 5; // Adjust this value according to your needs
        HttpSessionListener sessionListener = new CustomSessionManager(maxSessions);

        // Add the session listener to the HttpServletRequest object in your servlet
        // This can be done in the initialization method of your servlet
        // For example:
        // Servlet servlet = new MyServlet();
        // servlet.addSessionListener(sessionListener);
    }
}