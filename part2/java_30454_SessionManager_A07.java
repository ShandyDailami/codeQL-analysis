import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_30454_SessionManager_A07 implements HttpSessionListener {

    private int sessionCount = 0;

    public java_30454_SessionManager_A07() {
        System.out.println("SessionManager is created");
    }

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " created");
        sessionCount++;
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " destroyed, session count is now " + --sessionCount);
    }

    public static void main(String[] args) {
        HttpSession session = new HttpSession();
        SessionManager sm = new SessionManager();

        // Attach session listener
        session.setAttribute("sessionListener", sm);
    }
}