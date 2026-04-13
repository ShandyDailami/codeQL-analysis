import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33158_SessionManager_A03 implements HttpSessionListener {

    public java_33158_SessionManager_A03() {
        System.out.println("Session listener created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " created");
        // Set some session attributes
        se.getSession().setAttribute("username", "Guest");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session " + se.getSession().getId() + " destroyed");
    }

}