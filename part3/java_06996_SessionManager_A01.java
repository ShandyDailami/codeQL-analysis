import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

public class java_06996_SessionManager_A01 {

    public HttpSession createSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10); // Session will be valid for 10 seconds
        return session;
    }

    public void validateSession(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if (session.getAttribute("valid") == null) {
            request.logout();
            throw new ServletException("User does not exist or session has been invalidated");
        }
    }

    public void deleteSession(HttpSession session) {
        session.invalidate();
    }

    public static void main(String[] args) {
        // Put your main method code here
    }
}