import java.util.Optional;

public class java_22290_SessionManager_A01 {
    private Optional<Session> session;

    public java_22290_SessionManager_A01() {
        session = Optional.empty();
    }

    public void createSession() {
        System.out.println("Creating session");
        session = Optional.of(new Session());
    }

    public void breakAccessToSession() {
        System.out.println("Trying to break access to session");
        if (session.isPresent()) {
            session.get().breakAccess();
        } else {
            System.out.println("No session to break access");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession();
        sessionManager.breakAccessToSession();
    }

    static class Session {
        public void breakAccess() {
            System.out.println("Breaking access to session");
            // Some security-sensitive operation here
        }
    }
}