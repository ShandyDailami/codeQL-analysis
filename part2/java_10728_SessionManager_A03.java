import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class java_10728_SessionManager_A03 {

    private static final String COOKIE_NAME = "session";
    private static final String COOKIE_VALUE = "default_value";

    public void createSession(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        response.addCookie(cookie);
    }

    public void validateSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME) && cookie.getValue().equals(COOKIE_VALUE)) {
                    return; // Session is valid
                }
            }
        }
        // Session is invalid
        // You can redirect to a login page or any other action here
    }
}