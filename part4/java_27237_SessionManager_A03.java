import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_27237_SessionManager_A03 implements HttpSessionListener {

    private int sessionCount = 0;

    public java_27237_SessionManager_A03() {
        // No code here. It's only for initialization.
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        sessionCount++;
        event.getSession().setAttribute("sessionCount", sessionCount);
        System.out.println("Session " + sessionCount + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        sessionCount--;
        event.getSession().setAttribute("sessionCount", sessionCount);
        System.out.println("Session " + event.getSession().getId() + " destroyed.");
    }

    public static void main(String[] args) {
        // This is only for initialization. No code here.
    }
}