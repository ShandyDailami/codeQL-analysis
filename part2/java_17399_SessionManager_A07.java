import java.util.HashMap;

public class java_17399_SessionManager_A07 {
    private HashMap<String, String> sessionData;

    public java_17399_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessionData.containsKey(sessionId)) {
            System.out.println("AuthFailure: Session already in use");
            return;
        }

        sessionData.put(sessionId, "Session active");
        System.out.println("AuthFailure: Session started successfully");
    }

    public void endSession(String sessionId) {
        // Check if sessionId exists
        if (!sessionData.containsKey(sessionId)) {
            System.out.println("AuthFailure: Session not found");
            return;
        }

        sessionData.remove(sessionId);
        System.out.println("AuthFailure: Session ended successfully");
    }
}