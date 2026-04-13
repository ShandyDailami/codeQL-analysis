import java.util.HashMap;

public class java_00967_SessionManager_A03 {
    private static HashMap<Integer, String> sessionMap = new HashMap<>();
    private static int sessionID = 0;

    public static int startSession() {
        sessionID++;
        sessionMap.put(sessionID, "");
        return sessionID;
    }

    public static void setSessionAttribute(int sessionID, String attributeName, String attributeValue) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, attributeValue);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public static String getSessionAttribute(int sessionID, String attributeName) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            System.out.println("Invalid session ID");
            return null;
        }
    }

    public static boolean isValidSession(int sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    public static void endSession(int sessionID) {
        sessionMap.remove(sessionID);
    }
}