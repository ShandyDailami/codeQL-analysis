import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_31736_SessionManager_A07 implements HttpSessionListener {

    // this method will be called when a new session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
    }

    // this method will be called when a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    // this method is called when a new session is created, or an existing session is destroyed
    public static void main(String[] args) {
        // Create a new session and print its ID
        HttpSession session = new HttpSession();
        System.out.println("Created session: " + session.getId());

        // Add the session listener to the session
        session.addListener(new MySessionManager());

        // Destroy the session
        session.invalidate();
        System.out.println("Destroyed session: " + session.getId());
    }
}