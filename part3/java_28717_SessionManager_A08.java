import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_28717_SessionManager_A08 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " destroyed.");
   
        // Here, we're checking if the session context contains a session attribute
        if (se.getSession().getSessionContext() instanceof HttpSessionContext) {
            HttpSessionContext context = (HttpSessionContext) se.getSession().getSessionContext();
            if (context.getUserPrincipal() != null) {
                // This is a security-sensitive operation, so we're checking if the user has the 'IntegrityFailure' role
                if (context.getUserPrincipal().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_A08_INTEGRITY_FAILURE"))) {
                    // If the user has the required role, then we're destroying the session
                    se.getSession().invalidate();
                    System.out.println("Destroyed session for user due to integrity failure.");
                }
            }
        }
    }
}