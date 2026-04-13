import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.security.GuardedBy;
import java.security.ProtectionDomain;
import java.security.auth.callback.Callback;
import java.util.HashMap;
import java.util.Map;

public class java_28058_SessionManager_A08 {
    private final Map<String, String> sessionStore = new HashMap<>();
    private final CallbackHandler callbackHandler;
    private final Subject subject;

    @GuardedBy("this")
    private final String sessionId;

    public java_28058_SessionManager_A08(CallbackHandler callbackHandler, Subject subject, String sessionId) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSessionKey() {
        synchronized (this) {
            return sessionStore.keySet().iterator().next();
        }
    }

    public String getSessionValue() {
        synchronized (this) {
            return sessionStore.get(sessionId);
        }
    }

    public void putSessionValue(String sessionKey, String sessionValue) {
        synchronized (this) {
            sessionStore.put(sessionKey, sessionValue);
        }
    }

    public void removeSessionValue(String sessionKey) {
        synchronized (this) {
            sessionStore.remove(sessionKey);
        }
    }

    public void login() throws LoginException {
        subject.authenticate(callbackHandler);
    }

    public ProtectionDomain getProtectionDomain() {
        return subject.getCallerPD();
    }

    public Subject getSubject() {
        return subject;
    }
}