import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_35943_SessionManager_A07 {

    private Map<String, String> sessionMap;
    private Map<String, String> passwordMap;
    private Map<String, String> roleMap;

    public java_35943_SessionManager_A07() {
        sessionMap = new HashMap<>();
        passwordMap = new HashMap<>();
        roleMap = new HashMap<>();
    }

    public String createSession(String username, String password, String role) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        passwordMap.put(username, password);
        roleMap.put(username, role);
        return sessionId;
    }

    public String getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sessionId = request.getSession().getId();
        String username = sessionMap.get(sessionId);
        String password = passwordMap.get(username);
        String role = roleMap.get(username);

        if (authenticate(username, password, role)) {
            return sessionId;
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed.");
            return null;
        }
    }

    private boolean authenticate(String username, String password, String role) {
        // Here, we're only checking if the password matches. In a real world scenario, you'd also want to use a hashing algorithm.
        return password.equals(passwordMap.get(username));
    }

    private String generateSessionId() {
        // Here, we're just using a random session id for simplicity. In a real world scenario, you'd also want to generate a secure session id.
        return String.valueOf(System.currentTimeMillis());
    }
}