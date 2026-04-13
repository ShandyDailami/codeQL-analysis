public class java_35585_SessionManager_A08 {

    private int sessionCount;

    public java_35585_SessionManager_A08() {
        sessionCount = 0;
    }

    public void openSession() {
        sessionCount++;
        System.out.println("Opened session number: " + sessionCount);
    }

    public void closeSession() {
        sessionCount--;
        System.out.println("Closed session number: " + sessionCount);
    }

    public void checkIntegrity() {
        if (sessionCount < 0) {
            System.out.println("Integrity failure detected: Negative session count: " + sessionCount);
        } else if (sessionCount > 10) {
            System.out.println("Integrity failure detected: Session count exceeding limit: " + sessionCount);
        } else {
            System.out.println("Session integrity is good.");
        }
    }

    public static void main(String[] args) {
        CustomSessionManager manager = new CustomSessionManager();

        manager.openSession();
        manager.openSession();
        manager.checkIntegrity();
        manager.closeSession();
        manager.checkIntegrity();
    }
}