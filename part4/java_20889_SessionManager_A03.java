public class java_20889_SessionManager_A03 {
    private static int currentSessionCount = 0;

    private java_20889_SessionManager_A03() {
        // Private constructor to prevent instantiation
    }

    public static void openSession() {
        if (currentSessionCount < 5) {
            System.out.println("Opened session " + (currentSessionCount + 1));
            currentSessionCount++;
        } else {
            System.out.println("Cannot open more than 5 sessions. Closing one...");
            closeSession();
        }
    }

    public static void closeSession() {
        if (currentSessionCount > 0) {
            System.out.println("Closed session " + currentSessionCount);
            currentSessionCount--;
        } else {
            System.out.println("No session to close");
        }
    }
}