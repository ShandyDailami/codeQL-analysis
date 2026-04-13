import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_22995_SessionManager_A07 {
    private Map<String, HttpSession> sessions;
    private Map<String, String> sessionNames;
    private Map<String, String> sessionIDs;

    public java_22995_SessionManager_A07() {
        sessions = new HashMap<>();
        sessionNames = new HashMap<>();
        sessionIDs = new HashMap<>();
    }

    public String createSession(HttpServletRequest request, String sessionName) {
        HttpSession session = request.getSession();
        sessions.put(sessionName, session);
        sessionNames.put(session.getId(), sessionName);
        sessionIDs.put(sessionName, session.getId());
        return session.getId();
    }

    public String getSessionName(String sessionID) {
        return sessionNames.get(sessionID);
    }

    public String getSessionID(String sessionName) {
        return sessionIDs.get(sessionName);
    }

    public void endSession(String sessionName) {
        HttpSession session = sessions.get(sessionName);
        if (session != null) {
            session.invalidate();
            sessions.remove(sessionName);
            sessionNames.remove(session.getId());
            sessionIDs.remove(sessionName);
        }
    }
}