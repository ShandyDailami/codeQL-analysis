public class java_17776_SessionManager_A07 {
    private static HashMap<String, String> sessionMap = new HashMap<>();
    
    public static String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }
    
    public static String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }
    
    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}