import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class java_08943_SessionManager_A07 implements javax.servlet.http.SessionManager {
    private static Map<String, javax.servlet.http.Session> sessions = new HashMap<>();
    private static String AUTH_USERNAME = "admin";
    private static String AUTH_PASSWORD = "password";

    @Override
    public javax.servlet.http.Session createSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getRequestURI();
        javax.servlet.http.Session session = new javax.servlet.http.SessionImpl(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    @Override
    public void destroySession(HttpServletRequest request, HttpServletResponse response, javax.servlet.http.Session session) {
        sessions.remove(session.getId());
    }

    @Override
    public javax.servlet.http.Session getSession(HttpServletRequest request, HttpServletResponse response) {
        return sessions.get(request.getRequestURI());
    }

    @Override
    public void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
        destroySession(request, response, getSession(request, response));
    }

    private static boolean authenticate(String username, String password) {
        return username.equals(AUTH_USERNAME) && password.equals(AUTH_PASSWORD);
    }

    @Override
    public boolean validateSession(HttpServletRequest request, HttpServletResponse response, javax.servlet.http.Session session) {
        String sessionId = session.getId();
        return sessionId != null && sessions.containsKey(sessionId);
    }
}