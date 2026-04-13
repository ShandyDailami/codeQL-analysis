import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_28618_SessionManager_A08 implements HttpSessionListener {

    private static final long serialVersionUID = 1L;

    public java_28618_SessionManager_A08() {
    }

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " created.");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " destroyed.");
    }

    public static void main(String[] args) {
        // create new session manager
        SessionManager sessionManager = new SessionManager();

        // register session manager
        ServletContext context = new DefaultServletContext();
        context.addListener("Session", sessionManager);
    }
}