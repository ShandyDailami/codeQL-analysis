public class java_13069_SessionManager_A01 {

    private static int activeSessions = 0;
    private static final int MAX_SESSIONS = 10;

    public static synchronized void createSession() {
        if(activeSessions < MAX_SESSIONS){
            System.out.println("Session Created: " + activeSessions + 1);
            activeSessions++;
        } else {
            System.out.println("Maximum sessions reached.");
        }
    }

    public static synchronized void closeSession() {
        if(activeSessions > 0){
            System.out.println("Session Closed: " + activeSessions);
            activeSessions--;
        } else {
            System.out.println("No active sessions to close.");
        }
    }

    public static void main(String[] args) {
        createSession();
        createSession();
        closeSession();
        createSession();
        closeSession();
        createSession();
        createSession();
    }
}