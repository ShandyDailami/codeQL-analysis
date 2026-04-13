public class java_31472_SessionManager_A08 {
    private static int currentSessionId = 0;
    private static HashMap<Integer, Runtime.Version> versionMap = new HashMap<>();

    public static void startSession() {
        Runtime.Version version = Runtime.getRuntime().version();
        versionMap.put(++currentSessionId, version);
        System.out.println("Started session " + currentSessionId + " with version " + version);
    }

    public static void endSession() {
        int sessionId = currentSessionId--;
        Runtime.Version version = versionMap.get(sessionId);
        if (version != null) {
            System.out.println("Ended session " + sessionId + " with version " + version);
        } else {
            System.out.println("Ended session " + sessionId);
        }
    }

    public static void main(String[] args) {
        startSession();
        startSession();
        endSession();
        endSession();
    }
}