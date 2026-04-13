import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_27716_SessionManager_A03 implements HttpSessionListener {
    private int totalSessions = 0;
    
    public java_27716_SessionManager_A03() {
        // Nothing to do here
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        totalSessions++;
        System.out.println("Session Created: " + totalSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        totalSessions--;
        System.out.println("Session Destroyed: " + totalSessions);
    }

    public static void main(String[] args) {
        // Just an example, the listener will not be used, 
        // as the program will not actually create a HttpSession object.
        SessionManager manager = new SessionManager();
        // Create HttpSession here, not in sessionCreated method.
    }
}