public class java_20579_SessionManager_A08 {
    // The session list is a simple array that will hold all the created sessions
    private Session[] sessionList;

    // The total number of sessions in the list
    private int totalSessions;

    // The current number of sessions in use
    private int inUseSessions;

    // The maximum number of sessions allowed in the list
    private int maxSessions;

    public java_20579_SessionManager_A08(int maxSessions) {
        this.maxSessions = maxSessions;
        this.sessionList = new Session[maxSessions];
        this.totalSessions = 0;
        this.inUseSessions = 0;
    }

    // Method to create a new session
    public Session createSession() {
        if (this.totalSessions < this.maxSessions) {
            Session newSession = new Session();
            this.sessionList[this.totalSessions] = newSession;
            this.totalSessions++;
            return newSession;
        } else {
            System.out.println("Error: Unable to create a new session. The list is full.");
            return null;
        }
    }

    // Method to close a session
    public void closeSession(Session session) {
        int index = -1;
        for (int i = 0; i < this.totalSessions; i++) {
            if (this.sessionList[i] == session) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.sessionList[index] = null;
            this.totalSessions--;
            System.out.println("Session " + index + " closed.");
        } else {
            System.out.println("Error: Session not found.");
        }
    }
}