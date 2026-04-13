import java.util.HashMap;
import java.util.Map;

public class java_29397_SessionManager_A03 {

    // This is a simple session storage. In a real world scenario,
    // session data would be stored in a database, a server, or a remote service.
    private Map<String, String> sessionStorage;

    public java_29397_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public String createSession(String sessionID) {
        sessionStorage.put(sessionID, sessionID);
        return sessionID;
    }

    public String getSession(String sessionID) {
        return sessionStorage.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionStorage.remove(sessionID);
    }

}