import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_29124_SessionManager_A07 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
   
        // Check if the session is secure (i.e., it is not expired and not deactivated).
        // If it is not secure, it is a security violation.
        if (se.getSession().getLastAccessedTime() != se.getSession().getCreationTime()) {
            System.out.println("Security violation detected in session: " + se.getSession().getId());
        }
    }
}