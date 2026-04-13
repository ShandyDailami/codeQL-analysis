import java.util.HashMap;
import java.util.Map;

public class java_17391_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17391_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        sessionMap.put(userName, "Active");
    }

    public void endSession(String userName) {
        sessionMap.put(userName, "Inactive");
    }

    public String getSessionStatus(String userName) {
        return sessionMap.get(userName);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("User1");
        sessionManager.startSession("User2");

        System.out.println("User1 session status: " + sessionManager.getSessionStatus("User1"));
        System.out.println("User2 session status: " + sessionManager.getSessionStatus("User2"));

        sessionManager.endSession("User1");
        System.out.println("User1 session status after end: " + sessionManager.getSessionStatus("User1"));
    }
}