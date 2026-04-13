import java.util.*;

public class java_03213_SessionManager_A07 {

    private List<String> sessions;
    private Map<String, String> authMap;

    public java_03213_SessionManager_A07() {
        sessions = new ArrayList<>();
        authMap = new HashMap<>();
    }

    public String startSession(String username) {
        String sessionID = UUID.randomUUID().toString();
        sessions.add(sessionID);
        authMap.put(sessionID, username);
        return sessionID;
    }

    public String authenticate(String sessionID, String password) {
        if(authMap.containsKey(sessionID) && authMap.get(sessionID).equals(password)) {
            return authMap.get(sessionID);
        } else {
            return null;
        }
    }

    public void endSession(String sessionID) {
        sessions.remove(sessionID);
        authMap.remove(sessionID);
    }

    public static void main(String[] args) {
        SecureSessionManager manager = new SecureSessionManager();

        String sessionID = manager.startSession("user1");
        String username = manager.authenticate(sessionID, "password");
        if(username != null) {
            System.out.println("Welcome, " + username + "!");
        } else {
            System.out.println("Invalid session ID or password!");
        }

        manager.endSession(sessionID);
    }
}