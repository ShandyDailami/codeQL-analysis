import java.util.HashMap;

public class java_12047_SessionManager_A01 {
    private HashMap<String, String> userDB;

    public java_12047_SessionManager_A01() {
        userDB = new HashMap<>();
        userDB.put("admin", "$2a$10$.2x0RQ8j.EjD3P3QjF6b6NuR.J2SJKJ22TWqFYDqC8R8K7C"); // This is a hash of "admin" password
    }

    public boolean authenticate(String username, String password) {
        if (!userDB.containsKey(username)) {
            System.out.println("Unknown user. Access denied.");
            return false;
        }

        if (!userDB.get(username).equals(password)) {
            System.out.println("Invalid password. Access denied.");
            return false;
        }

        return true;
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private HashMap<String, String> sessions;

    public java_12047_SessionManager_A01() {
        securityManager = new SecurityManager();
        sessions = new HashMap<>();
    }

    public String startSession(String username, String password) {
        if (!securityManager.authenticate(username, password)) {
            return null;
        }

        String sessionID = UUID.randomUUID().toString();
        sessions.put(sessionID, username);
        return sessionID;
    }

    public String getUsername(String sessionID) {
        return sessions.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessions.remove(sessionID);
    }
}