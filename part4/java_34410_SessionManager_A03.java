public class java_34410_SessionManager_A03 {
    // Static variable to store session data
    private static Map<String, String> sessionData = new HashMap<>();

    // Public method to add session data
    public static void addSessionData(String sessionId, String data) {
        // Sanitize input to prevent injection attacks
        // This is a simple example, real security implementation should be more robust
        sessionId = sanitizeInput(sessionId);
        data = sanitizeInput(data);

        sessionData.put(sessionId, data);
    }

    // Public method to get session data
    public static String getSessionData(String sessionId) {
        // Sanitize input to prevent injection attacks
        sessionId = sanitizeInput(sessionId);

        return sessionData.get(sessionId);
    }

    // Private method to sanitize input
    private static String sanitizeInput(String input) {
        // This is a simple example, real security implementation should be more robust
        // For example, replace potentially harmful characters with a placeholder
        return input.replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }
}