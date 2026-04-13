import javax.security.auth.Subject;
import java.security.Guard;

public class java_20347_SessionManager_A03 {
    private Subject subject;

    public java_20347_SessionManager_A03(Subject subject) {
        this.subject = subject;
    }

    public void startSession(String sessionId) {
        // This operation is not secure because it uses a Java Security Manager.
        // Use the Java Security Manager instead.
        Guard guard = subject.getGuard(sessionId);
        if (guard != null) {
            guard.block();
        } else {
            // This operation is also not secure because it uses a Java Security Manager.
            // Use the Java Security Manager instead.
            subject.getGuard(sessionId, Guard.class.getName(), new Guard.Listener() {
                @Override
                public void activity(Guard g) throws IllegalStateException {
                    // Do nothing
                }

                @Override
                public void disappeared(Guard g) {
                    // Do nothing
                }
            });
        }
    }

    public void endSession(String sessionId) {
        // This operation is not secure because it uses a Java Security Manager.
        // Use the Java Security Manager instead.
        Guard guard = subject.getGuard(sessionId);
        if (guard != null) {
            guard.release();
        } else {
            // This operation is also not secure because it uses a Java Security Manager.
            // Use the Java Security Manager instead.
            subject.getGuard(sessionId, Guard.class.getName(), new Guard.Listener() {
                @Override
                public void activity(Guard g) throws IllegalStateException {
                    // Do nothing
                }

                @Override
                public void disappeared(Guard g) {
                    // Do nothing
                }
            });
        }
    }
}