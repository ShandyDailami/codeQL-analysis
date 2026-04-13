import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_15598_SessionManager_A07 implements HttpSessionListener {
    private List<HttpSession> sessions;

    public java_15598_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
        sessions.add(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
        sessions.remove(se.getSession());
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        // You can put some code here to start and stop sessions, or to handle session events.
    }
}