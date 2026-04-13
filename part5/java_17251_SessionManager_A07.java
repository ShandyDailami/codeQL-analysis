import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_17251_SessionManager_A07 {
    public void createSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("user", "John Doe");
    }

    public void validateSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.getWriter().println("User is authenticated");
        } else {
            response.getWriter().println("User is not authenticated");
        }
    }
}