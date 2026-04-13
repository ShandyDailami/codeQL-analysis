import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_35007_SessionManager_A07 implements HttpSessionListener {
    private static final String AUTHENTICATION_FAILURE_KEY = "A07_AuthFailure";

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        session.setAttribute(AUTHENTICATION_FAILURE_KEY, false);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // No need for cleanup in this simple example
    }

    public static boolean isAuthenticationFailure(HttpSession session) {
        return (boolean) session.getAttribute(AUTHENTICATION_FAILURE_KEY);
    }

    public static void setAuthenticationFailure(HttpSession session, boolean failure) {
        session.setAttribute(AUTHENTICATION_FAILURE_KEY, failure);
    }
}