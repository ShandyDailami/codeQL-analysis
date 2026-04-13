import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_21365_SessionManager_A01 implements HttpSessionListener {

    private int totalSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        totalSessions++;
        System.out.println("Session " + totalSessions + " created. Total: " + totalSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        totalSessions--;
        System.out.println("Session " + totalSessions + " destroyed. Total: " + totalSessions);
    }
}