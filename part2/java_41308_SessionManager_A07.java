import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SetUtils;

import java.util.Set;

public class java_41308_SessionManager_A07 {
    // Set to store all the active sessions
    private Set<String> activeSessions;

    public java_41308_SessionManager_A07() {
        this.activeSessions = SetUtils.synchronizedSet(new HashSet<>());
    }

    // Method to create a new session
    public String createSession() {
        // Generate a unique session ID
        String sessionId = RandomStringUtils.randomAlphanumeric(16);

        // Store the session ID in the set
        activeSessions.add(sessionId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the set
        activeSessions.remove(sessionId);
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        // Check if the session ID is in the set
        return activeSessions.contains(sessionId);
    }
}