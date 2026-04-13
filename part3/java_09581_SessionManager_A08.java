import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_09581_SessionManager_A08 implements HttpSessionListener {

    private static int activeSessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessionCount++;
        System.out.println("Session Created: Active Sessions = " + activeSessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessionCount--;
        System.out.println("Session Destroyed: Active Sessions = " + activeSessionCount);
    }

    // This is a static listener, so it won't listen for any changes in any session attributes.
    // But it's an example of a listener that could be used for other security sensitive operations.
    // The 'se' parameter is not used in this example.
    public static void main(String[] args) {
        System.out.println("Custom Session Manager is starting up...");
    }
}