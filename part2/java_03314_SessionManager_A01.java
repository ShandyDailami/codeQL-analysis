public class java_03314_SessionManager_A01 {

    private static final String SESSION_COOKIE_NAME = "sessionId";

    private java_03314_SessionManager_A01() {}

    public static void startSession(String userId) {
        // Create a new session
        String sessionId = UUID.randomUUID().toString();
        // Set the session cookie
        HttpServletResponse response = (HttpServletResponse) ServletActionContext.getResponse();
        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
        // Store the session in a Map
        SessionManager.sessionMap.put(sessionId, userId);
    }

    public static void endSession(HttpServletRequest request, HttpServletResponse response) {
        // Get the session cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SESSION_COOKIE_NAME.equals(cookie.getName())) {
                    // Remove the session cookie
                    Cookie expiredCookie = new Cookie(SESSION_COOKIE_NAME, cookie.getValue());
                    expiredCookie.setPath("/");
                    expiredCookie.setMaxAge(0);
                    response.addCookie(expiredCookie);
                    // Remove the session from the Map
                    SessionManager.sessionMap.remove(cookie.getValue());
                    break;
                }
           
            }
        }
    }

    public static String getUserId(HttpServletRequest request, HttpServletResponse response) {
        // Get the session cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SESSION_COOKIE_NAME.equals(cookie.getName())) {
                    // Return the user id from the Map
                    return SessionManager.sessionMap.get(cookie.getValue());
                }
            }
        }
        return null;
    }

    private static Map<String, String> sessionMap = new ConcurrentHashMap<>();

}