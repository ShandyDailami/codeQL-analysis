import java.util.HashMap;
import java.util.Map;

public class java_13047_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_13047_SessionManager_A01() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean isAuthorized(String username, String password) {
        String expectedPassword = userMap.get(username);
        if (expectedPassword == null) {
            return false;
        }
        return expectedPassword.equals(password);
    }

    public Session getSession(String username) {
        if (isAuthorized(username, "securePassword")) {
            return new Session();
        } else {
            return null;
        }
    }

    public class Session {
        // Session class definition
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser("alice", "password1");
        sessionManager.addUser("bob", "password2");

        Session session = sessionManager.getSession("alice");
        if (session != null) {
            // Session is authorized, proceed with using it.
        } else {
            // Session is not authorized, handle it appropriately.
        }
    }
}