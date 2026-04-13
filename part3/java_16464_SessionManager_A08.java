import javax.security.auth.Subject;
import java.security.Principal;

public class java_16464_SessionManager_A08 {
    // Simplified version of a Principal, as the purpose of this example is to check session status
    private static class MyPrincipal implements Principal {
        private boolean active;

        public java_16464_SessionManager_A08(boolean active) {
            this.active = active;
        }

        public String getName() {
            return "User";
        }
    }

    public Subject.Session doStuff(Subject subject) {
        // Create a new session
        Subject.Session session = subject.getSession();

        // Check if the session is active
        if (!session.isActive()) {
            throw new SecurityException("Session is not active");
        }

        // Simulate a security-sensitive operation
        System.out.println("Performing security-sensitive operation");

        // Return the session
        return session;
    }

    public static void main(String[] args) {
        // Create a subject with a principal
        Subject subject = new Subject.Builder().build(new MyPrincipal(true));

        // Create a session manager and do some stuff
        SessionManager sessionManager = new SessionManager();
        sessionManager.doStuff(subject);
    }
}