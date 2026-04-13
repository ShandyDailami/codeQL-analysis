import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class java_20986_SessionManager_A03 {
    private Map<String, String> sessions = new HashMap<>();
    private Map<String, Cookie> cookies = new HashMap<>();

    public void createSession(String sessionId, HttpServletResponse response) {
        sessions.put(sessionId, "Session active");
        Cookie cookie = new Cookie("sessionId", sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void validateSession(String sessionId, HttpServletRequest request) {
        Cookie sessionCookie = getCookie("sessionId", request);
        if (sessionCookie != null) {
            if (sessions.containsKey(sessionCookie.getValue())) {
                System.out.println("Session active");
            } else {
                System.out.println("Session expired or not found");
            }
        } else {
            System.out.println("Session not found");
        }
    }

    private Cookie getCookie(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}