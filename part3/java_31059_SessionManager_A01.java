import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

public class java_31059_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private CallbackHandler callbackHandler;
    private Subject subject;

    public java_31059_SessionManager_A01(CallbackHandler callbackHandler, Subject subject) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
        this.sessionMap = new HashMap<>();
    }

    public String getSession(String userName) {
        // Use callbackHandler to authenticate user and get password
        // CallbackHandler is not used here but is used for managing authentication

        // Now use the password to generate a sessionId
        String password = this.callbackHandler.handle(subject);
        String sessionId = password.hashCode() + "-" + userName;
        this.sessionMap.put(sessionId, password);
        return sessionId;
    }

    public String getSession(String sessionId) {
        // Check if sessionId is valid
        if (this.sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void invalidateSession(String sessionId) {
        // Invalidate session by removing it from sessionMap
        this.sessionMap.remove(sessionId);
    }
}