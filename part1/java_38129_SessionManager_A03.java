import java.util.concurrent.atomic.AtomicInteger;

public class java_38129_SessionManager_A03 {
    private final AtomicInteger sessionId;
    private final SessionRepository sessionRepository;

    public java_38129_SessionManager_A03(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionId = new AtomicInteger(0);
    }

    public String createSession() {
        int currentSessionId;
        do {
            currentSessionId = sessionId.incrementAndGet();
        } while (!sessionRepository.saveSession(currentSessionId));

        return String.valueOf(currentSessionId);
    }

    public void deleteSession(String sessionId) {
        sessionRepository.deleteSession(sessionId);
    }
}