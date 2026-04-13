import java.util.HashMap;

public class java_40735_SessionManager_A08 {
    private HashMap<String, String> sessionData;

    public java_40735_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public String getSessionData(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public void deleteSessionData(String sessionId) {
        sessionData.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            System.out.println("Integrity Check Passed: Session " + sessionId + " data is valid.");
        } else {
            System.out.println("Integrity Check Failed: Session " + sessionId + " data is invalid.");
        }
    }
}