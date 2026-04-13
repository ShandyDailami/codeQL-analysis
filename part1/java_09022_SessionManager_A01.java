import java.util.HashMap;
import java.util.Map;

public class java_09022_SessionManager_A01 {
    private Map<String, Boolean> sessionMap;
    private boolean isBroken;

    public java_09022_SessionManager_A01() {
        sessionMap = new HashMap<>();
        isBroken = false;
    }

    public void startSession(String sessionId) {
        if (isBroken()) {
            System.out.println("Broken Session Manager detected. Cannot start session.");
            return;
        }
        sessionMap.put(sessionId, true);
    }

    public void endSession(String sessionId) {
        if (isBroken()) {
            System.out.println("Broken Session Manager detected. Cannot end session.");
            return;
       
        }
        sessionMap.remove(sessionId);
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1");
        sessionManager.endSession("session1");
        sessionManager.setBroken(true);
        sessionManager.startSession("session2"); // This should cause an error
    }
}