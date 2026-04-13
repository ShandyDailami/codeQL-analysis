import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class java_18895_SessionManager_A03 {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public java_18895_SessionManager_A03(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void startSession() throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", "username");
        response.sendRedirect("session.jsp");
    }

    public void checkSession() throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            response.sendRedirect("session.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    public void destroySession() throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            response.sendRedirect("logout.jsp");
        } else {
            response.sendRedirect("not-found.jsp");
        }
    }
}