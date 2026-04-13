import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_21591_SessionManager_A07 {

    private static final String SESSION_ATTRIBUTE_NAME = "username";

    public String getUsernameFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (String) session.getAttribute(SESSION_ATTRIBUTE_NAME);
    }

    public void setUsernameInSession(HttpServletRequest request, String username) {
        HttpSession session = request.getSession(true);
        session.setAttribute(SESSION_ATTRIBUTE_NAME, username);
    }
}