import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_38552_SessionManager_A08 implements HttpSessionListener {

    private int sessionCount = 0;

    public java_38552_SessionManager_A08() {
        // Add this session listener to all existing session
        listener();
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session created: " + event.getSession().getId());
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session destroyed: " + event.getSession().getId());
        sessionCount--;
        // Here you can add code to check for integrity failures.
        // For simplicity, we'll just print the count.
        System.out.println("Current session count: " + sessionCount);
    }

    public void listener() {
        // Here you can add code to add this listener to all existing sessions.
        // For simplicity, we'll just print which session listener is added.
        System.out.println("Added session listener");
    }
}