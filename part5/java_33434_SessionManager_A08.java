import java.util.HashMap;

public class java_33434_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_33434_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionIdentifier) {
        if (sessionMap.containsKey(sessionIdentifier)) {
            System.out.println("Error: Session already exists for this identifier.");
            return null;
        }
        sessionMap.put(sessionIdentifier, sessionIdentifier);
        return sessionIdentifier;
    }

    public String getSession(String sessionIdentifier) {
        return sessionMap.get(sessionIdentifier);
    }

    public void deleteSession(String sessionIdentifier) {
        if (sessionMap.containsKey(sessionIdentifier)) {
            sessionMap.remove(sessionIdentifier);
        } else {
            System.out.println("Error: No session found for this identifier.");
        }
    }

    public void integrityCheck(String sessionIdentifier) {
        if (sessionMap.containsKey(sessionIdentifier)) {
            System.out.println("Integrity check successful. Session exists for this identifier.");
        } else {
            System.out.println("Error: Session does not exist for this identifier.");
        }
    }
}