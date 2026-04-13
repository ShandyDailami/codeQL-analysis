import java.util.concurrent.atomic.AtomicInteger;

public class java_20958_SessionManager_A03 {
    private AtomicInteger sessionIdCounter = new AtomicInteger();

    public int getNextSessionId() {
        return sessionIdCounter.incrementAndGet();
    }

    public void validateSession(int sessionId) throws SessionNotFoundException, SessionNotValidException {
        if (sessionId <= 0) {
            throw new SessionNotFoundException("Session ID is invalid or not set yet");
        }

        // Replace this with actual session validation logic
        if (sessionId % 2 == 0) {
            throw new SessionNotValidException("Session ID is not valid. It is even");
        }
    }
}

class SessionNotFoundException extends Exception {
    public java_20958_SessionManager_A03(String message) {
        super(message);
    }
}

class SessionNotValidException extends Exception {
    public java_20958_SessionManager_A03(String message) {
        super(message);
    }
}