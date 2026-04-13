public class java_28459_SessionManager_A01 {
    private static int sessions = 0;
    private java_28459_SessionManager_A01() {}

    public static SessionManager getInstance() {
        sessions++;
        return new SessionManager();
    }

    public void startSession() {
        if(sessions > 0) {
            System.out.println("Starting session number: " + sessions);
        } else {
            System.out.println("No session started yet.");
        }
    }

    public void endSession() {
        if(sessions > 0) {
            System.out.println("Ending session number: " + sessions);
            sessions--;
        } else {
            System.out.println("No session ended yet.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sm1 = SessionManager.getInstance();
        sm1.startSession();

        SessionManager sm2 = SessionManager.getInstance();
        sm2.startSession();

        sm1.endSession();

        SessionManager sm3 = SessionManager.getInstance();
        sm3.startSession();

        sm2.endSession();
    }
}