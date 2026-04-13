import java.security.InvalidParameterException;

public class java_00111_SessionManager_A08 {

    private static final int MAX_SESSIONS = 100;
    private int currentSessions = 0;

    public void openSession() {
        if(currentSessions < MAX_SESSIONS) {
            currentSessions++;
            System.out.println("Opened session: " + currentSessions);
        } else {
            throw new SecurityException("Maximum sessions reached.");
        }
    }

    public void closeSession() {
        if(currentSessions > 0) {
            currentSessions--;
            System.out.println("Closed session: " + currentSessions);
        } else {
            throw new SecurityException("No sessions to close.");
        }
    }

    public void prolongSession(int minutes) {
        if(minutes < 0) {
            throw new InvalidParameterException("Invalid prolongment time.");
        }
        long millis = (long) (minutes * 60 * 1000);
        long currentTime = System.currentTimeMillis();
        long nextSessionTime = currentTime + millis;
        long nextOpenSessionTime = nextSessionTime - millis;

        while (true) {
            long openSessionTime = nextOpenSessionTime;
            if (openSessionTime > currentTime) {
                // Session still open.
                throw new SecurityException("Cannot prolong session in this moment.");
            }

            if (openSessionTime <= currentTime) {
                // Session is closed.
                break;
            }
        }

        System.out.println("Prolonged session by " + minutes + " minutes.");
    }
}