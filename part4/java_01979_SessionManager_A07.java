import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_01979_SessionManager_A07 {

    private static final String SESSION_ID_KEY = "sessionId";

    public void createSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();
        request.getSession().setAttribute(SESSION_ID_KEY, sessionId);
        response.setHeader("Set-Cookie", "SESSIONID=" + sessionId + "; path=/");
    }

    public void validateSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();
        String storedSessionId = (String) request.getSession().getAttribute(SESSION_ID_KEY);
        if (!sessionId.equals(storedSessionId)) {
            // Authentication failure, destroy session and remove cookie
            request.getSession().invalidate();
            response.addHeader("Set-Cookie", "SESSIONID=" + sessionId + "; path=/; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        }
    }

    public void deleteSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        request.getSession().invalidate();
        response.addHeader("Set-Cookie", "SESSIONID=" + sessionId + "; path=/; expires=Thu, 01 Jan 1970 00:00:00 GMT");
    }
}