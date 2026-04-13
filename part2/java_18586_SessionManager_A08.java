public class java_18586_SessionManager_A08 {
    private static int count = 0;
    private String sessionID;

    public java_18586_SessionManager_A08() {
        count++;
        this.sessionID = "Session-" + count;
    }

    public void openSession() {
        System.out.println("Opened session: " + this.sessionID);
    }

    public void closeSession() {
        System.out.println("Closed session: " + this.sessionID);
    }

    public void checkSession() {
        if (count < 10) {
            System.out.println("Session: " + this.sessionID + " is valid.");
        } else {
            System.out.println("Session: " + this.sessionID + " is invalid.");
        }
    }
}