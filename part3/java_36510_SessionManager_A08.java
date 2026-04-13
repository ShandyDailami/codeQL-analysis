import java.util.HashMap;
import java.util.Map;

public class java_36510_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_36510_SessionManager_A08() {
        sessionMap = new HashMap<>();
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

    public boolean integrityCheck(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("A08_IntegrityFailure1", "Data1");
        sessionManager.createSession("A08_IntegrityFailure2", "Data2");

        System.out.println("Integrity check for A08_IntegrityFailure1: " + sessionManager.integrityCheck("A08_IntegrityFailure1"));
        System.out.println("Session data for A08_IntegrityFailure1: " + sessionManager.getSessionData("A08_IntegrityFailure1"));

        System.out.println("Integrity check for A08_IntegrityFailure2: " + sessionManager.integrityCheck("A08_IntegrityFailure2"));
        System.out.println("Session data for A08_IntegrityFailure2: " + sessionManager.getSessionData("A08_IntegrityFailure2"));

        sessionManager.deleteSession("A08_IntegrityFailure1");
        sessionManager.deleteSession("A08_IntegrityFailure2");

        System.out.println("After delete, integrity check for A08_IntegrityFailure1: " + sessionManager.integrityCheck("A08_IntegrityFailure1"));
        System.out.println("After delete, session data for A08_IntegrityFailure1: " + sessionManager.getSessionData("A08_IntegrityFailure1"));
    }
}