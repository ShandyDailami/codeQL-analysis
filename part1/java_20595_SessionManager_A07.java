import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

public class java_20595_SessionManager_A07 {

    private static final String SESSION_ID_COOKIE_NAME = "session_id";
    private static final String SESSION_ID_COOKIE_PATH = "/";

    private static final List<String> SECRET_WORDS = Arrays.asList("password", "security", "sessions", "cookies");

    public HttpSession validateSession(HttpServletRequest request) {
        HttpSession session = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SESSION_ID_COOKIE_NAME.equals(cookie.getName())) {
                    String sessionId = cookie.getValue();
                    session = getSession(sessionId);
                    if (session != null) {
                        break;
                    }
                }
            }
        }
        if (session == null) {
            session = startNewSession(request);
        } else {
            session = renewSession(session);
        }
        return session;
    }

    private HttpSession startNewSession(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        for (String word : SECRET_WORDS) {
            if (sessionId.contains(word)) {
                throw new SecurityException("Session ID contains sensitive information, cannot start a new session.");
            }
        }
        HttpSession newSession = request.getSession();
        newSession.setAttribute("authenticated", false);
        return newSession;
    }

    private HttpSession renewSession(HttpSession session) {
        if (session.getAttribute("authenticated") == null || !(boolean) session.getAttribute("authenticated")) {
            for (String word : SECRET_WORDS) {
                if ((session.getId()).contains(word)) {
                    throw new SecurityException("Session ID contains sensitive information, cannot renew the session.");
                }
            }
            session.setAttribute("authenticated", true);
        }
        return session;
    }

    private HttpSession getSession(String sessionId) {
        return request.getSession(sessionId);
    }
}