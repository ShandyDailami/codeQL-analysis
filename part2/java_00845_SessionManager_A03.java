import java.util.ArrayList;
import java.util.List;

public class java_00845_SessionManager_A03 {
    private List<Integer> sessionIds;
    private static int nextSessionId = 1;

    public java_00845_SessionManager_A03() {
        sessionIds = new ArrayList<>();
    }

    public int createSession() {
        int sessionId = nextSessionId++;
        sessionIds.add(sessionId);
        return sessionId;
    }

    public void closeSession(int sessionId) throws Exception {
        if (!sessionIds.contains(sessionId)) {
            throw new Exception("Session not found");
        }

        sessionIds.remove(sessionId);
    }
}