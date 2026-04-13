import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_12090_SessionManager_A01 implements HttpSessionListener {

    private int sessionCount = 0;

    public java_12090_SessionManager_A01() {
        // Constructor, if any
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        System.out.println("Session " + sessionCount + " created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        System.out.println("Session " + sessionCount + " destroyed.");
    }

    public static void main(String[] args) {
        MySessionManager sessionManager = new MySessionManager();
        // Example of using the session manager
        HttpSession session = sessionManager.createSession();
    }
}