import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_40463_SessionManager_A07 {
    private HttpServletRequest request;

    public java_40463_SessionManager_A07(HttpServletRequest request) {
        this.request = request;
    }

    public void startSession() {
        HttpSession session = request.getSession();
        session.setAttribute("authenticated", false);
        session.setAttribute("authorized", false);
    }

    public void authenticateUser(String username, String password) {
        // Simple authentication by checking username and password
        if ("admin".equals(username) && "password".equals(password)) {
            request.getSession().setAttribute("authenticated", true);
        }
    }

    public void authorizeUser(int userId) {
        // Simple authorization by checking userId
        if (userId == 1) {
            request.getSession().setAttribute("authorized", true);
        }
    }

    public boolean isUserAuthenticated() {
        return (boolean) request.getSession().getAttribute("authenticated");
    }

    public boolean isUserAuthorized() {
        return (boolean) request.getSession().getAttribute("authorized");
    }
}