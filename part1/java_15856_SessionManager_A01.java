import javax.servlet.http.*;

public class java_15856_SessionManager_A01 {
    private static final String SESSION_COOKIE_NAME = "sessionId";

    public static void startSession(HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        response.addCookie(new Cookie(SESSION_COOKIE_NAME, sessionId)); // Add the session ID to the response
    }

    public static String getSessionId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_COOKIE_NAME)) {
                    return cookie.getValue(); // Return the session ID
                }
            }
        }
        return null; // Return null if the session ID is not found
    }

    public static void endSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = getSessionId(request);
        if (sessionId != null) {
            response.addCookie(new Cookie(SESSION_COOKIE_NAME, sessionId)); // Add the session ID to the response
        }
    }
}