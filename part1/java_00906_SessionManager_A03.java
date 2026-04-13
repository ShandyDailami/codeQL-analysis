import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.codec.binary.Base64;

public class java_00906_SessionManager_A03 {
    private Map<String, HttpSession> sessionMap;
    private SecureRandom random;

    public java_00906_SessionManager_A03() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public HttpSession createSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = generateSessionId(request);
        HttpSession session = new HttpSession(request.getRequestedSessionId(), response.getResponseHeader("Set-Cookie"), request.getContextPath());
        sessionMap.put(sessionId, session);
        return session;
    }

    private String generateSessionId(HttpServletRequest request) {
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        String sessionId = Base64.encodeBase64URLSafeString(randomBytes);
        if (request.getSessionTrackingModified()) {
            Cookie cookie = new Cookie("JSESSIONID", sessionId);
            cookie.setPath("/");
            cookie.setSecure(true); // Required for secure cookies.
            response.addCookie(cookie);
        }
        return sessionId;
    }

    public HttpSession getSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSessionId();
        if (sessionId == null) {
            sessionId = request.getHeader("Cookie"); // Secure cookies are sent in the "Cookie" header.
        }
        if (sessionId == null) {
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSessionId();
        if (sessionId == null) {
            sessionId = request.getHeader("Cookie"); // Secure cookies are sent in the "Cookie" header.
        }
        if (sessionId == null) {
            return;
        }
        HttpSession session = sessionMap.remove(sessionId);
        session.invalidate();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}