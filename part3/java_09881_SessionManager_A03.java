import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_09881_SessionManager_A03 implements HttpSessionListener {

    // This counter will be used to keep track of active sessions
    private int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
        System.out.println("Session " + se.getSession().getId() + " created. Active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
        System.out.println("Session " + se.getSession().getId() + " destroyed. Active sessions: " + activeSessions);
    }

    // This method is used to check if the user is authenticated in a secure way
    public boolean isUserAuthenticated(String username, String password) {
        // For simplicity, we're assuming a hard-coded username and password
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // In a real-world application, you would not use this directly
        // Instead, you would use it in a Servlet or other Java EE component
        MySessionManager sessionManager = new MySessionManager();
        // This should be done in a secure and secure way, not in a legacy style
    }
}