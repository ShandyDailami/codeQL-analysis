import java.util.*;

public class java_27969_SessionManager_A03 {

    private static Map<String, String> sessionMap = new HashMap<>();

    public static void startSession(String userId) {
        // You should generate a random key for each session and store it in the map.
        // Use UUIDs for this purpose.
        String sessionKey = UUID.randomUUID().toString();
        sessionMap.put(sessionKey, userId);
        System.out.println("Started session: " + sessionKey);
    }

    public static void endSession(String sessionKey) {
        // You should check if the session key exists in the map.
        // If it does, remove it from the map.
        if (sessionMap.containsKey(sessionKey)) {
            String userId = sessionMap.get(sessionKey);
            sessionMap.remove(sessionKey);
            System.out.println("Ended session for user: " + userId);
        } else {
            System.out.println("No session found for key: " + sessionKey);
        }
    }

    public static String getUserId(String sessionKey) {
        // You should check if the session key exists in the map.
        // If it does, return the user id associated with that session key.
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            System.out.println("No session found for key: " + sessionKey);
            return null;
        }
    }
}