import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_29977_SessionManager_A03 implements HttpSessionListener {

    private static final String ADMIN_PASSWORD = "admin";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Do nothing.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // If the session was created with the correct password, delete it.
        if (se.getSession().getAttribute("password").equals(ADMIN_PASSWORD)) {
            se.getSession().invalidate();
        }
    }

    public static void main(String[] args) {
        // Start the server with the session manager.
        SessionManager sm = new SessionManager();
        // Note: This code is assuming that the session manager will be started in a separate thread.
        // If you want to test it in the main thread, you should create a new HttpSession and use the setAttribute method.
    }
}