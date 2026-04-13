import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class java_38280_SessionManager_A08 {

    private HashMap<String, String> sessionMap;
    private SimpleDateFormat sdf;

    public java_38280_SessionManager_A08() {
        sessionMap = new HashMap<>();
        sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    }

    public String createSession() {
        String sessionId = sdf.format(new Date());
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public boolean containsSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String session1 = sm.createSession();
        String session2 = sm.createSession();
        System.out.println("Created sessions: " + session1 + ", " + session2);

        if (sm.containsSession(session1)) {
            System.out.println("Session exists");
        } else {
            System.out.println("Session does not exist");
        }

        sm.deleteSession(session2);

        if (sm.containsSession(session2)) {
            System.out.println("Session still exists");
        } else {
            System.out.println("Session has been deleted");
        }
    }
}