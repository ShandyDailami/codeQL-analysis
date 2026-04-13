import java.util.*;

public class java_08523_SessionManager_A03 {
    private static HashMap<String, String> sessionMap = new HashMap<String, String>();
    private static int sessionCount = 0;

    public static String createSession(String user) {
        sessionCount++;
        String sessionID = "Session_" + sessionCount;
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public static String getUser(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        } else {
            return "Invalid session";
        }
    }

    public static String validateSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return "Valid session";
        } else {
            return "Invalid session";
        }
    }

    public static String endSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            sessionMap.remove(sessionID);
            return "Session ended";
        } else {
            return "Invalid session";
        }
    }

    public static void main(String[] args) {
        String user = "John";
        String sessionID = createSession(user);
        System.out.println(sessionID);
        System.out.println(getUser(sessionID));
        System.out.println(validateSession(sessionID));
        System.out.println(endSession(sessionID));
        System.out.println(getUser(sessionID));
    }
}