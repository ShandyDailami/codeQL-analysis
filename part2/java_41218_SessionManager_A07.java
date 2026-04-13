import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class java_41218_SessionManager_A07 {
    private static final String LOGIN_PAGE = "/login.jsp";
    private static final String ADMIN_PAGE = "/admin.jsp";

    public void authenticate(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Here you can add your logic to validate the username and password
        // If everything is correct, create a session and redirect to the admin page
        if ("admin".equals(username) && "password".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(ADMIN_PAGE);
        } else {
            response.sendRedirect(LOGIN_PAGE);
        }
    }

    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        // Here you can add your logic to logout the user
        session.invalidate();
        response.sendRedirect(LOGIN_PAGE);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("authenticate".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            authenticate(username, password, request, response);
        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                logout(session, response);
            } else {
                response.sendRedirect(LOGIN_PAGE);
            }
        }
    }
}