import java.util.HashMap;

public class java_11153_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_11153_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void handleBrokenAccessControl(String sessionId) {
        // Adding a check to see if the sessionId is valid before proceeding
        if (sessions.containsKey(sessionId)) {
            String user = sessions.get(sessionId);
            // The user should be able to access other users' data
            if (user.equals("admin")) {
                System.out.println("Access Denied: User " + user + " cannot access other users' data");
            } else {
                System.out.println("Access Granted: User " + user + " can access other users' data");
            }
        } else {
            System.out.println("Invalid Session ID");
        }
    }
}