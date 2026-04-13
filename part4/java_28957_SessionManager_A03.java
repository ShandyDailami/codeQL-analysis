import java.util.HashMap;
import java.util.Map;

public class java_28957_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_28957_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {

    public static void main(String[] args) {

        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("A01", "SessionData1");
        sessionManager.createSession("A02", "SessionData2");

        System.out.println("Session A01 Data: " + sessionManager.getSessionData("A01"));
        System.out.println("Session A02 Data: " + sessionManager.getSessionData("A02"));

        sessionManager.deleteSession("A01");

        System.out.println("After Deletion Session A01 Data: " + sessionManager.getSessionData("A01"));
    }
}