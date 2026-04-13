import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33843_SessionManager_A07 implements HttpSessionListener {

    private int totalSessions = 0;

    public java_33843_SessionManager_A07() {
        System.out.println("Initializing Session Listener...");
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
        HttpSessionListener listener = new MySessionListener();
        // Add listener to your servlet context, or start it up
    }
}