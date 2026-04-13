import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class java_02301_SessionManager_A07 {

    private static final String SESSION_ID_COOKIE_NAME = "sessionId";
    private static final int SESSION_ID_COOKIE_AGE = 600; // 600 seconds

    public String getSessionId(HttpServletRequest request) {
        Cookie sessionIdCookie = getCookie(request, SESSION_ID_COOKIE_NAME);
        if (sessionIdCookie != null) {
            return sessionIdCookie.getValue();
        }
        return null;
    }

    public void setSessionId(HttpServletRequest request, String sessionId) {
        Cookie sessionIdCookie = new Cookie(SESSION_ID_COOKIE_NAME, sessionId);
        sessionIdCookie.setMaxAge(SESSION_ID_COOKIE_AGE);
        request.getResponse().addCookie(sessionIdCookie);
    }

    private Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void endSession(HttpServletRequest request) {
        String sessionId = getSessionId(request);
        if (sessionId != null) {
            setSessionId(request, sessionId);
        }
    }

    public void startSession(HttpServletRequest request) {
        String sessionId = java.util.UUID.randomUUID().toString();
        setSessionId(request, sessionId);
    }
}