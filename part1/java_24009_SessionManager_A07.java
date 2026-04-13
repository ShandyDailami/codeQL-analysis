import java.util.HashMap;
import java.util.Map;

public class java_24009_SessionManager_A07 {

    // A map to store user sessions.
    private static Map<String, String> sessionMap = new HashMap<>();

    // User authentication method.
    public static String authenticate(String userName, String password) {
        // This is a simple authentication method, in a real-world application, this would require a secure
        // authentication service.
        if (userName.equals("admin") && password.equals("password")) {
            return "Admin";
        }
        return null;
    }

    // Session creation method.
    public static String createSession(String userName) {
        // Generate a random session ID.
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, userName);
        return sessionID;
    }

    // Session retrieval method.
    public static String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Session destruction method.
    public static void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public static void main(String[] args) {
        // Authenticate the user.
        String userName = "admin";
        String password = "password";
        String user = authenticate(userName, password);

        if (user != null) {
            // Create a session.
            String sessionID = createSession(user);
            System.out.println("Session created for user " + user + ", session ID: " + sessionID);

            // Retrieve the session.
            String retrievedUser = getSession(sessionID);
            System.out.println("Retrieved user from session: " + retrievedUser);

            // Destroy the session.
            destroySession(sessionID);
            System.out.println("Session destroyed");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}