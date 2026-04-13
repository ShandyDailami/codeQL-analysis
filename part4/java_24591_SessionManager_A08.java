public class java_24591_SessionManager_A08 {
    private static int sessionCount = 0;

    public java_24591_SessionManager_A08() {
        sessionCount++;
    }

    public static int getSessionCount() {
        return sessionCount;
    }

    public static void main(String[] args) {
        SessionManager sm1 = new SessionManager();
        SessionManager sm2 = new SessionManager();
        SessionManager sm3 = new SessionManager();

        System.out.println("Session count: " + SessionManager.getSessionCount());

        // Add your code here
    }
}