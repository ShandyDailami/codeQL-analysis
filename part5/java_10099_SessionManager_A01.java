import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

public class java_10099_SessionManager_A01 {
    private Map<String, Subject> sessionIdToSubjectMap;

    public java_10099_SessionManager_A01() {
        sessionIdToSubjectMap = new HashMap<>();
    }

    public String startSession(Subject subject) {
        String sessionId = UUID.randomUUID().toString();
        sessionIdToSubjectMap.put(sessionId, subject);
        return sessionId;
    }

    public Subject getSubject(String sessionId) throws SessionNotFoundException {
        Subject subject = sessionIdToSubjectMap.get(sessionId);
        if (subject == null) {
            throw new SessionNotFoundException("Session not found for session id: " + sessionId);
        }
        return subject;
    }

    public void endSession(String sessionId) {
        sessionIdToSubjectMap.remove(sessionId);
    }

    public void checkAccessControl(String sessionId) {
        Subject subject = getSubject(sessionId);
        // here you would implement the logic to check if the subject is allowed to access the session
        // if not, you would throw an exception or handle it in some way to break the session
    }
}

class SessionNotFoundException extends Exception {
    public java_10099_SessionManager_A01(String message) {
        super(message);
    }
}