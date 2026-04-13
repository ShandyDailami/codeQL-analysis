import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class java_25252_SessionManager_A01 {
    public static final String COOKIE_NAME = "sessionId";

    public void startSession(HttpServletResponse response, String userId) {
        String sessionId = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(COOKIE_NAME, sessionId);
        response.addCookie(cookie);
        // Store userId in session
        // ...
    }

    public void endSession(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        // Remove userId from session
        // ...
    }

    public String getSessionUserId(HttpServletRequest request) {
        Cookie cookie = Arrays.stream(request.getCookies())
            .filter(c -> c.getName().equals(COOKIE_NAME))
            .findFirst()
            .orElse(null);

        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }
}