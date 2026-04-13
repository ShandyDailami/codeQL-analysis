import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class java_35254_SessionManager_A03 {
    private static final String SESSION_KEY = "userId";

    public static void startSession(HttpServletResponse response, String userId) {
        Cookie cookie = new Cookie(SESSION_KEY, userId);
        cookie.setPath("/"); // Set path to / so the cookie is accessible across the site.
        response.addCookie(cookie);
    }

    public static String getSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_KEY)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void endSession(HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION_KEY, null);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}