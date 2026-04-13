import java.security.SecureRandom;

public class java_02951_SessionManager_A08 {
    // Array to store session IDs
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int SECURE_RANDOM_STRING_LENGTH = 10;
    private static SecureRandom random = new SecureRandom();
    
    // Session IDs will be stored in this list
    private static List<String> sessions = new ArrayList<>();
    
    // Method to generate a session ID
    public static String generateSessionId() {
        return generateRandomString(SECURE_RANDOM_STRING_LENGTH);
    }
    
    // Method to generate a random string
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
    
    // Method to validate a session ID
    public static boolean validateSessionId(String sessionId) {
        return sessions.contains(sessionId);
    }
    
    // Method to register a session ID
    public static void registerSessionId(String sessionId) {
        sessions.add(sessionId);
    }
    
    // Method to deregister a session ID
    public static void deregisterSessionId(String sessionId) {
        sessions.remove(sessionId);
    }
}