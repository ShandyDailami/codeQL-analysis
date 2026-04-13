import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_24446_SessionManager_A07 implements HttpSessionListener {
    private static final String VALID_USER = "validUser";
    private static final String INVALID_USER = "invalidUser";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Do nothing
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        if (session.getAttribute(VALID_USER) != null) {
            session.invalidate();
        }
    }

    public static void main(String[] args) {
        HttpSession session = new HttpSession();
        session.setAttribute(VALID_USER, "User1");
        sessionManager.listener = new MySessionManager();

        // Testing session hijacking
        HttpSession invalidSession = new HttpSession();
        invalidSession.setAttribute(VALID_USER, "InvalidUser");

        // Testing CSRF attacks
        HttpSession csrfSession = new HttpSession();
        csrfSession.setAttribute("_csrf", "InvalidCsrfToken");
        csrfSession.setAttribute("user", "User2");
    }
}