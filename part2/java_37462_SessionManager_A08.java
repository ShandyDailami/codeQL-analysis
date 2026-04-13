public class java_37462_SessionManager_A08 {

    private static int SESSION_COUNT = 0;
    private static ArrayList<String> activeSessions = new ArrayList<>();

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession();
        sm.startSession();
        sm.endSession(1);
        sm.endSession(2);
        sm.endSession(3);
    }

    public void startSession() {
        SESSION_COUNT++;
        activeSessions.add("Session " + SESSION_COUNT);
        System.out.println("Started session: " + SESSION_COUNT);
    }

    public void endSession(int sessionId) {
        if (activeSessions.contains("Session " + sessionId)) {
            activeSessions.remove("Session " + sessionId);
            System.out.println("Ended session: " + sessionId);
        } else {
            System.out.println("No session found for ID: " + sessionId);
        }
    }
}