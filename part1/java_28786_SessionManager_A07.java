import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_28786_SessionManager_A07 implements HttpSessionListener {

    private static final long SESSION_TIMEOUT = 1800; // in seconds

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Nothing to do here
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // If the session was created less than SESSION_TIMEOUT seconds ago, delete the session
        if (se.getSession().getLastAccessedTime() + SESSION_TIMEOUT < System.currentTimeMillis()) {
            se.getSession().invalidate();
        }
    }
}