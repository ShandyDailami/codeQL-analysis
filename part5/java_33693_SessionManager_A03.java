import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_33693_SessionManager_A03 implements HttpSessionListener {

    private int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session Created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session Destroyed: " + se.getSession().getId());
   
        if (activeSessions == 0) {
            System.out.println("No active sessions, all done.");
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the session manager
        MySessionManager sessionManager = new MySessionManager();

        // Register the session listener
        // Note: This is not the standard way of doing it, but it's a starting point
        // You should register this in a servlet context, or use an application-wide event bus instead
        sessionManager.getClass().getClassLoader().loadClass("javax.servlet.http.HttpSession").getMethod("addSessionListener", HttpSessionListener.class).invoke(sessionManager, sessionManager);
    }
}