import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class java_14054_SessionManager_A01 {

    private String correctUsername;
    private String correctPassword;

    public java_14054_SessionManager_A01() {
        this.correctUsername = "user";
        this.correctPassword = "password";
    }

    public void secureRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String providedUsername = request.getParameter("username");
        String providedPassword = request.getParameter("password");

        if (authenticate(providedUsername, providedPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized attempt to access the resource.");
            return;
        }

        request.getRequestDispatcher("/secureResource").forward(request, response);
    }

    private boolean authenticate(String providedUsername, String providedPassword) {
        return providedUsername.equals(correctUsername) && providedPassword.equals(correctPassword);
    }
}