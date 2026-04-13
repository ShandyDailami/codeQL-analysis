import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class java_17234_SessionManager_A07 {
    private HttpServletRequest request;

    public java_17234_SessionManager_A07(HttpServletRequest request) {
        this.request = request;
    }

    public void startSession() {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.setAttribute("authenticated", true);
        } else {
            session.setAttribute("authenticated", false);
        }
    }

    public void endSession() {
        HttpSession session = request.getSession();
        if (!session.isNew()) {
            session.setAttribute("authenticated", false);
        }
    }

    public boolean isAuthenticated() {
        HttpSession session = request.getSession();
        HttpSessionContext sessionContext = session.getSessionContext();
        if (sessionContext == null) {
            return false;
        }
        return (Boolean) sessionContext.getAuthenticationUser();
    }
}