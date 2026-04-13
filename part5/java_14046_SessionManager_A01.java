import java.util.Base64;

public class java_14046_SessionManager_A01 {

    private static final String COOKIE_NAME = "MY_SESSION";
    private static final String COOKIE_PATH = "/";
    private static final String COOKIE_DOMAIN = "localhost";
    private static final int COOKIE_MAX_AGE = 180;

    public String createSession(String userId) {
        String sessionId = java.util.UUID.randomUUID().toString();
        String sessionCookie = COOKIE_NAME + "=" + sessionId + "; Path=" + COOKIE_PATH + "; Domain=" + COOKIE_DOMAIN + "; Max-Age=" + COOKIE_MAX_AGE;
        return sessionCookie;
    }

    public String getSession(String sessionCookie) {
        String[] cookies = sessionCookie.split(";");
        for (String cookie : cookies) {
            if (cookie.startsWith(COOKIE_NAME + "=")) {
                String value = cookie.substring(COOKIE_NAME.length() + 1);
                return new String(Base64.getDecoder().decode(value));
            }
        }
        return null;
    }
}