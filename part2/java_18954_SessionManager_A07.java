import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_18954_SessionManager_A07 implements HttpSessionListener {

    // A map to store authenticated users
    private static java.util.Map<String, Boolean> loggedInUsers = new java.util.HashMap<>();

    public java_18954_SessionManager_A07() {
    }

    // This method is called when a user logs in
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Store the user name in the session
        loggedInUsers.put(session.getId(), true);
    }

    // This method is called when a user logs out
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Remove the user name from the session
        loggedInUsers.remove(session.getId());
    }

    // This method checks if a user is authenticated
    public static boolean isUserLoggedIn(HttpSession session) {
        return loggedInUsers.get(session.getId()) != null && (boolean) loggedInUsers.get(session.getId());
    }

    public static boolean isUserAuthenticated(String userName) {
        return loggedInUsers.get(userName) != null && (boolean) loggedInUsers.get(userName);
    }
}