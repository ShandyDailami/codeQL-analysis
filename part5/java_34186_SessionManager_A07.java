import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_34186_SessionManager_A07 {

    private static final String SALT = "SALT";

    private static String createHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String createSessionId(HttpServletRequest request, String username) {
        return createHash(request.getRemoteAddr() + username + SALT);
    }

    public static void registerSession(String sessionId, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.setId(sessionId);
        response.addHeader("Set-Cookie", "session=" + sessionId + "; Path=/");
    }

    public static void destroySession(String sessionId, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.invalidate();
        response.addHeader("Set-Cookie", "session=deleted; Path=/; Expires=Thu, 01 Jan 1970 00:00:00 GMT");
    }

    public static void secureOperation(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (!session.isNew()) {
            // Secure operation here
        } else {
            // Unsecured operation here
        }
    }
}