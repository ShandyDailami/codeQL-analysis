import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_38300_SessionManager_A07 implements HttpSessionListener {

    // This method is called when a session is created
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: " + se.getSession().getId());
    }

    // This method is called when a session is destroyed
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: " + se.getSession().getId());
    }

    // This method is called to create a session
    public HttpSession createSession() {
        return javax.servlet.http.HttpSessionFactory.util.createSession(this, "newSession");
    }

    // This method is called to invalidate a session
    public void invalidateSession(HttpSession session) {
        session.invalidate();
    }

    // This method is called to get a session from a session id
    public HttpSession getSession(String sessionId) {
        return javax.servlet.http.HttpSessionFactory.util.getSession(this, sessionId);
    }

    // Main method to test the above code
    public static void main(String[] args) {
        HttpSession session = new MySessionManager().createSession();
        session.setAttribute("testAttribute", "Test Value");
        MySessionManager manager = new MySessionManager();
        manager.invalidateSession(session);
        session = manager.getSession(session.getId());
        System.out.println(session.getAttribute("testAttribute"));
    }
}