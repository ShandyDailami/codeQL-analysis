import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class java_26854_SessionManager_A08 {

    private static final String SESSION_COOKIE_NAME = "sessionId";
    private static final int COOKIE_MAX_AGE = 60 * 60 * 24; // One day

    public static void createSession(HttpServletResponse response, String sessionId) throws IOException {
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        cookie.setMaxAge(COOKIE_MAX_AGE);
        cookie.setPath("/"); // Set path to be the root directory
        response.addCookie(cookie);
    }

    public static String getSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (SESSION_COOKIE_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void destroySession(HttpServletResponse response) {
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}