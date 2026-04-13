import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class java_03492_SessionManager_A07 {
    private Map<UUID, UsernamePasswordAuthenticationToken> sessionMap = new ConcurrentHashMap<>();

    public UUID startSession(String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, authToken);

        // Store sessionId in context for later use
        SecurityContextHolder.getContext().setAuthentication(authToken);

        return sessionId;
    }

    public void endSession(UUID sessionId) {
        // Clear the session and authentication token for the session
        sessionMap.remove(sessionId);
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    public UsernamePasswordAuthenticationToken getSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }
}