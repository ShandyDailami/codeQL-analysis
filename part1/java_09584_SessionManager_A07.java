import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_09584_SessionManager_A07 implements HttpSessionListener {

    private static int activeSessions = 0;

    public java_09584_SessionManager_A07() {
        // Register the session listener
        HttpSessionListener httpSessionListener = new HttpSessionListener() {
            public void sessionCreated(HttpSessionEvent httpSessionEvent) {
                activeSessions++;
                System.out.println("Session created. Total active sessions: " + activeSessions);
            }

            public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
                activeSessions--;
                System.out.println("Session destroyed. Total active sessions: " + activeSessions);
           
            }
        };

        // Add the session listener to the session context
        // (which defaults to servlet 3.0 and above)
        try {
            httpSessionListener.sessionCreated(null);
        } catch (UnsupportedOperationException e) {
            System.out.println("HttpSessionListener not supported");
        }
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public static void main(String[] args) {
        new SecureSessionManager();
        System.out.println("Initial active sessions: " + getActiveSessions());

        try {
            Thread.sleep(1000);
            System.out.println("After 1 second, active sessions: " + getActiveSessions());
            Thread.sleep(1000);
            System.out.println("After 2 seconds, active sessions: " + getActiveSessions());
            Thread.sleep(1000);
            System.out.println("After 3 seconds, active sessions: " + getActiveSessions());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}