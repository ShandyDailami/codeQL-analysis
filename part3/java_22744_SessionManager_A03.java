public class java_22744_SessionManager_A03 {
    private static final int MAX_SIZE = 10;
    private static int currentSize = 0;
    private static Map<String, String> sessionMap = new HashMap<>();

    public static void startSession(String userId) {
        if (currentSize < MAX_SIZE) {
            sessionMap.put(userId, createSession());
            currentSize++;
        } else {
            System.out.println("Session limit reached. Session " + userId + " has been ignored");
        }
    }

    public static String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public static void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
            currentSize--;
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }

    private static String createSession() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        startSession("user1");
        startSession("user2");
        startSession("user3");
        startSession("user4");
        startSession("user5");
        startSession("user6");

        System.out.println("Session1: " + getSession("user1"));
        System.out.println("Session2: " + getSession("user2"));
        System.out.println("Session3: " + getSession("user3"));
        System.out.println("Session4: " + getSession("user4"));
        System.out.println("Session5: " + getSession("user5"));
        System.out.println("Session6: " + getSession("user6"));

        endSession("user2");
        endSession("user4");

        System.out.println("Session2: " + getSession("user2"));
        System.out.println("Session4: " + getSession("user4"));

        startSession("user7");

        System.out.println("Session7: " + getSession("user7"));
    }
}