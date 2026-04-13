import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_02141_SessionManager_A03 implements HttpSessionListener {
    private int sessionCount = 0;

    public java_02141_SessionManager_A03() {
        System.out.println("SessionManager created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        sessionCount++;
        System.out.println("Session " + sessionCount + " created by " + session.getSessionID());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        sessionCount--;
        System.out.println("Session " + sessionCount + " destroyed by " + session.getSessionID());
    }

    public static void main(String[] args) {
        new SessionManager();
    }
}