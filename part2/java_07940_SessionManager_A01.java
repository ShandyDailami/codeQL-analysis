import java.util.HashMap;
import java.util.Map;

public class java_07940_SessionManager_A01 {
    // This is a simulated user database. In a real application, this would be replaced with a real database.
    private Map<String, String> userDatabase = new HashMap<>();

    public String getUser(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return username;
        }
        return null;
    }

    // This is a mock method for a session. In a real application, this would be replaced with a real session.
    public Session getSession(String username) {
        Session session = new Session();
        session.setUser(username);
        return session;
    }

    // This is a mock method for checking a session fixation vulnerability. In a real application, this would be replaced with a real session.
    public boolean isSessionFixedationVulnerable(Session session) {
        if (session.getUser().equals(session.getPreviousUser())) {
            return true;
        }
        return false;
    }
}

public class Session {
    private String user;
    private String previousUser;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.previousUser = this.user;
        this.user = user;
    }

    public String getPreviousUser() {
        return previousUser;
    }
}

public class BrokenAccessControlExample {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Attempting to log in with a bad password
        String username = "bad_user";
        String password = "bad_password";
        String sessionUser = sessionManager.getUser(username, password);

        if (sessionUser == null) {
            System.out.println("Failed to log in");
            return;
        }

        // Attempting to use the session
        Session session = sessionManager.getSession(sessionUser);

        // Checking for session fixation vulnerability
        if (sessionManager.isSessionFixedationVulnerable(session)) {
            System.out.println("Session fixation vulnerability detected");
        }
    }
}