import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33137_SessionManager_A01 implements HttpSessionListener {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Empty implementation
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String username = session.getAttribute("username");
        String password = session.getAttribute("password");

        if (!isValidCredentials(username, password)) {
            session.invalidate();
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}